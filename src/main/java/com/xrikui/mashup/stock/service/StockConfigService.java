package com.xrikui.mashup.stock.service;

import cn.hutool.core.date.DateUtil;
import com.xrikui.mashup.common.constant.CharConstant;
import com.xrikui.mashup.common.service.RestTemplateService;
import com.xrikui.mashup.common.utils.BigDecimalUtils;
import com.xrikui.mashup.common.utils.DateTimeUtils;
import com.xrikui.mashup.stock.dto.RateDto;
import com.xrikui.mashup.stock.entity.StockConfig;
import com.xrikui.mashup.stock.entity.StockConfigExample;
import com.xrikui.mashup.stock.entity.StockRecord;
import com.xrikui.mashup.stock.mapper.StockConfigMapper;
import com.xrikui.mashup.stock.mapper.StockRecordMapper;
import com.xrikui.mashup.stock.mapper.ext.StockRecordExtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockConfigService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockConfigService.class);

    @Autowired
    private MashupConfigService mashupConfigService;
    @Autowired
    private RestTemplateService restTemplateService;
    @Autowired
    private StockSendMessageService stockSendMessageService;
    @Autowired
    private StockConfigMapper stockConfigMapper;
    @Autowired
    private StockRecordMapper stockRecordMapper;
    @Autowired
    private StockRecordExtMapper stockRecordExtMapper;


    /**
     * 根据启用标识查询全部配置
     *
     * @param mark 启用标识
     * @return
     */
    public List<StockConfig> findAllStockConfig(String mark) {
        StockConfigExample stockConfigExample = new StockConfigExample();
        stockConfigExample.createCriteria().andStockMarkEqualTo(mark);
        return stockConfigMapper.selectByExample(stockConfigExample);
    }


    /**
     * 查询 && 通知
     *
     * @param stockConfigList 股票配置
     */
    public void loop(List<StockConfig> stockConfigList) {
        String baseUrl = mashupConfigService.findConfigByName("sinajs");
        stockConfigList.forEach(stockConfig -> {
            StockRecord stockRecord = handlerRestContent(rest(baseUrl, stockConfig));
            if (null != stockRecord) {
                LOGGER.info("【实时通知】开始处理发送逻辑,当前记录股票名称:{}", stockRecord.getName());
                RateDto rateDto = stockSendMessageService.send(stockRecord);

                // 插入记录
                stockRecord.setNowRate(rateDto.getNowRateString());
                stockRecord.setLastRate(rateDto.getLastRateString());
                stockRecordExtMapper.insertByDuplicateKey(stockRecord);
                LOGGER.info("【实时通知】完成处理发送逻辑,当前记录股票名称:{}", stockRecord.getName());
            } else {
                LOGGER.info("【实时通知】未查询到对应的股票信息,当前记录股票代码:{}", stockConfig.getStockCode());
            }
        });
    }


    /**
     * 处理返回内容
     *
     * @param restContent
     */
    private StockRecord handlerRestContent(String restContent) {
        int index = restContent.indexOf('"');
        if (-1 == index) {
            return null;
        }
        String[] splitList = restContent.substring(index + 1, restContent.length() - 2).split(CharConstant.DOU_HAO);
        StockRecord stockRecord = new StockRecord();
        stockRecord.setName(splitList[0]);
        stockRecord.setTodayDate(DateUtil.format(new Date(), DateTimeUtils.yyyyMMdd));
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
     * @return
     */
    public String rest(String baseUrl, StockConfig stockConfig) {
        return restTemplateService.get(baseUrl + stockConfig.getStockCode(), String.class);
    }
}
