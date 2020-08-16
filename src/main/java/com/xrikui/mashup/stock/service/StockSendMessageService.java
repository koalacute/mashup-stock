package com.xrikui.mashup.stock.service;

import cn.hutool.core.date.DateUtil;
import com.xrikui.mashup.common.constant.CharConstant;
import com.xrikui.mashup.common.service.RestTemplateService;
import com.xrikui.mashup.common.utils.BigDecimalUtils;
import com.xrikui.mashup.common.utils.ColorUtils;
import com.xrikui.mashup.common.utils.DateTimeUtils;
import com.xrikui.mashup.feige.entity.DataDetail;
import com.xrikui.mashup.feige.entity.Detail;
import com.xrikui.mashup.feige.entity.SendMessageRequestDto;
import com.xrikui.mashup.stock.entity.StockConfig;
import com.xrikui.mashup.stock.entity.StockRecord;
import com.xrikui.mashup.stock.mapper.ext.StockRecordExtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class StockSendMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockSendMessageService.class);

    @Value("${send.feige.url}")
    private String sendFeiGeUrl;

    @Value("${send.feige.secret}")
    private String sendFeiGeSecret;

    @Value("${send.feige.appKey}")
    private String sendFeiGeAppKey;

    @Value("${send.feige.templateId}")
    private String sendFeiGeTemplateId;

    private final StockRecordService stockRecordService;
    private final RestTemplateService restTemplateService;
    private final MashupConfigService mashupConfigService;
    private final StockRecordExtMapper stockRecordExtMapper;

    @Autowired
    public StockSendMessageService(StockRecordService stockRecordService,
                                   RestTemplateService restTemplateService,
                                   MashupConfigService mashupConfigService,
                                   StockRecordExtMapper stockRecordExtMapper) {
        this.stockRecordService = stockRecordService;
        this.restTemplateService = restTemplateService;
        this.mashupConfigService = mashupConfigService;
        this.stockRecordExtMapper = stockRecordExtMapper;
    }

    /**
     * 查询 && 通知
     *
     * @param stockConfigList 股票配置列表
     */
    public void loop(List<StockConfig> stockConfigList) {
        String baseUrl = mashupConfigService.findConfigByName("新浪股票信息获取地址");
        stockConfigList.forEach(stockConfig -> {
            StockRecord stockRecord = handlerRestContent(rest(baseUrl, stockConfig));
            if (null != stockRecord) {
                LOGGER.info("【实时股价监控】开始发送监控通知,当前记录股票名称:{}", stockRecord.getName());
                send(stockRecord);
                LOGGER.info("【实时股价监控】完成发送监控通知,当前记录股票名称:{}", stockRecord.getName());

                LOGGER.info("【实时股价监控】开始更新监控信息,当前记录股票名称:{}", stockRecord.getName());
                stockRecordExtMapper.insertByDuplicateKey(stockRecord);
                LOGGER.info("【实时股价监控】完成更新监控信息,当前记录股票名称:{}", stockRecord.getName());
            } else {
                LOGGER.info("【实时股价监控】未查询到对应的股票信息,当前记录股票代码:{}", stockConfig.getStockCode());
            }
        });
    }


    /**
     * 查询股票信息后,处理返回需要的记录信息
     *
     * @param restContent 请求获取到的股票原始返回消息
     */
    private StockRecord handlerRestContent(String restContent) {
        int index = restContent.indexOf('"');
        if (-1 == index) {
            return null;
        }
        String[] splitList = restContent.substring(index + 1, restContent.length() - 2).split(CharConstant.DOU_HAO);
        StockRecord stockRecord = new StockRecord();
        stockRecord.setName(splitList[0]);
        stockRecord.setTodayDate(DateUtil.format(new Date(), DateTimeUtils.YYYY_MM_DD));
        stockRecord.setTodayOpenPrice(BigDecimalUtils.transform(splitList[1]));
        stockRecord.setYesterdayClosePrice(BigDecimalUtils.transform(splitList[2]));
        stockRecord.setCurrentPrice(BigDecimalUtils.transform(splitList[3]));
        stockRecord.setTodayHighestPrice(BigDecimalUtils.transform(splitList[4]));
        stockRecord.setTodayLowestPrice(BigDecimalUtils.transform(splitList[5]));
        stockRecord.setCreateTime(new Date());
        stockRecord.setUpdateTime(new Date());
        return stockRecord;
    }


    /**
     * 发起请求
     *
     * @param baseUrl     基础地址
     * @param stockConfig 股票配置
     */
    public String rest(String baseUrl, StockConfig stockConfig) {
        return restTemplateService.get(baseUrl + stockConfig.getStockCode(), String.class);
    }


    /**
     * 发送通知
     *
     * @param stockRecord 记录信息
     */
    public void send(StockRecord stockRecord) {

        // 查询前一条记录
        StockRecord stockRecordLast = stockRecordService.findLastStockRecord(stockRecord.getName());
        if (null == stockRecordLast) {
            return;
        }

        // 校验封装 && 发送通知
        if (checkSendMessageCondition(stockRecord, stockRecordLast)) {
            SendMessageRequestDto sendMessageRequestDto = packageRequestDto(stockRecord);
            restTemplateService.post(sendFeiGeUrl, sendMessageRequestDto);
        }
    }


    /**
     * 检查是否满足发送条件 true：满足  false：不满足
     *
     * @param stockRecord     当前查询出来的记录信息
     * @param stockRecordLast 上次查询出来的记录信息
     */
    private boolean checkSendMessageCondition(StockRecord stockRecord, StockRecord stockRecordLast) {

        // 当前价格
        BigDecimal currentPrice = stockRecord.getCurrentPrice();
        // 昨收价格
        BigDecimal yesterdayPrice = stockRecord.getYesterdayClosePrice();

        if (currentPrice.compareTo(BigDecimal.ZERO) == 0 || yesterdayPrice.compareTo(BigDecimal.ZERO) == 0) {
            return false;
        }

        // 相对于昨收价格的涨跌幅
        BigDecimal nowRate = BigDecimalUtils.calculateRate(currentPrice, yesterdayPrice, 4);
        // 相对于上次价格的涨跌幅
        BigDecimal lasRate = BigDecimalUtils.calculateRate(currentPrice, stockRecordLast.getCurrentPrice(), 4);

        // 相对于昨收价格的涨跌幅 （百分比）
        stockRecord.setNowRate(nowRate.multiply(BigDecimal.valueOf(100L)).setScale(2) + "%");
        // 相对于上次价格的涨跌幅 （百分比）
        stockRecord.setLastRate(lasRate.multiply(BigDecimal.valueOf(100L)).setScale(2) + "%");


        String nowRateRefer = mashupConfigService.findConfigByName("当前涨跌幅参数");
        String lasRateRefer = mashupConfigService.findConfigByName("上次涨跌幅参数");

        return (nowRate.abs()).compareTo(BigDecimalUtils.transform(nowRateRefer)) > 0 && (lasRate.abs()).compareTo(BigDecimalUtils.transform(lasRateRefer)) > 0;
    }


    /**
     * 封装飞鸽通知请求参数
     *
     * @param stockRecord 当前股票记录信息
     */
    private SendMessageRequestDto packageRequestDto(StockRecord stockRecord) {
        SendMessageRequestDto sendMessageRequestDto = new SendMessageRequestDto(sendFeiGeSecret, sendFeiGeAppKey, sendFeiGeTemplateId);

        Detail first = new Detail("当前价格:" + stockRecord.getCurrentPrice() + ", 当前涨跌率:" + stockRecord.getNowRate(), ColorUtils.RED);
        Detail keyword1 = new Detail(stockRecord.getName(), ColorUtils.RED);
        Detail keyword2 = new Detail(DateUtil.format(new Date(), DateTimeUtils.YYYY_MM_DD_HH_MM_SS), ColorUtils.BLUE_PRO);
        Detail remark = new Detail("较上次记录涨跌浮:" + stockRecord.getLastRate(), ColorUtils.RED);

        sendMessageRequestDto.setData(new DataDetail(first, keyword1, keyword2, remark));
        return sendMessageRequestDto;
    }
}
