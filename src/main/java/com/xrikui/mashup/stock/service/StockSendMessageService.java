package com.xrikui.mashup.stock.service;

import cn.hutool.core.date.DateUtil;
import com.xrikui.mashup.common.utils.DateTimeUtils;
import com.xrikui.mashup.feige.entity.DataDetail;
import com.xrikui.mashup.feige.entity.Detail;
import com.xrikui.mashup.feige.entity.SendMessageRequestDto;
import com.xrikui.mashup.feige.service.SendMessageService;
import com.xrikui.mashup.stock.dto.RateDto;
import com.xrikui.mashup.stock.entity.StockRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class StockSendMessageService {

    @Value("${send.feige.url}")
    private String sendFeiGeUrl;

    @Value("${send.feige.secret}")
    private String sendFeiGeSecret;

    @Value("${send.feige.appKey}")
    private String sendFeiGeAppKey;

    @Value("${send.feige.templateId}")
    private String sendFeiGeTemplateId;

    @Autowired
    private StockRecordService stockRecordService;
    @Autowired
    private SendMessageService sendMessageService;


    /**
     * 处理逻辑
     *
     * @param stockRecord 记录信息
     */
    public RateDto send(StockRecord stockRecord) {
        // 当前价格
        BigDecimal currentPrice = stockRecord.getCurrentPrice();
        // 昨收价格
        BigDecimal yesterdayClosePrice = stockRecord.getYesterdayClosePrice();

        // 查询前一条记录
        StockRecord stockRecordLast = stockRecordService.findLastStockRecord(stockRecord.getName());
        RateDto rateDto = new RateDto();
        if (null != stockRecordLast) {
            BigDecimal currentPriceLast = stockRecordLast.getCurrentPrice();

            BigDecimal nowRate = currentPrice.subtract(yesterdayClosePrice).divide(yesterdayClosePrice, 4, BigDecimal.ROUND_HALF_UP);
            BigDecimal lastRate = currentPrice.subtract(currentPriceLast).divide(currentPriceLast, 4, BigDecimal.ROUND_HALF_UP);

            boolean flag1 = (nowRate.abs()).compareTo(BigDecimal.valueOf(0.01)) > 0;
            boolean flag2 = (lastRate.abs()).compareTo(BigDecimal.valueOf(0.005)) > 0;

            String nowRateString = nowRate.multiply(BigDecimal.valueOf(100L)) + "%";
            String lastRateString = lastRate.multiply(BigDecimal.valueOf(100L)) + "%";


            rateDto.setNowRateString(nowRateString);
            rateDto.setLastRateString(lastRateString);

            if (flag1 && flag2) {

                // 封装请求参数
                SendMessageRequestDto sendMessageRequestDto = packageRequestDto(stockRecord.getName(), currentPrice, nowRateString, lastRateString);

                // 则发送通知，调用通知服务
                sendMessageService.send(sendMessageRequestDto, sendFeiGeUrl);
            }
        }
        return rateDto;
    }

    /**
     * 封装飞鸽通知请求参数
     *
     * @param stockName      股票名称
     * @param currentPrice   当前价格
     * @param nowRateString  当前涨跌幅
     * @param lastRateString 较上一次的涨跌幅
     */
    private SendMessageRequestDto packageRequestDto(String stockName, BigDecimal currentPrice, String nowRateString, String lastRateString) {
        SendMessageRequestDto sendMessageRequestDto = new SendMessageRequestDto();
        sendMessageRequestDto.setSecret(sendFeiGeSecret);
        sendMessageRequestDto.setApp_key(sendFeiGeAppKey);
        sendMessageRequestDto.setTemplate_id(sendFeiGeTemplateId);

        Detail first = new Detail();
        first.setValue("当前价格:" + currentPrice + ", 当前涨跌率:" + nowRateString);
        first.setColor("#FF0000");

        Detail keyword1 = new Detail();
        keyword1.setValue(stockName);
        keyword1.setColor("#FF0000");

        Detail keyword2 = new Detail();
        keyword2.setValue(DateUtil.format(new Date(), DateTimeUtils.yyyyMMddHHmmss));
        keyword2.setColor("#173177");

        Detail remark = new Detail();
        remark.setValue("较上次记录涨跌浮:" + lastRateString);
        remark.setColor("#FF0000");

        DataDetail dataDetail = new DataDetail();
        dataDetail.setFirst(first);
        dataDetail.setKeyword1(keyword1);
        dataDetail.setKeyword2(keyword2);
        dataDetail.setRemark(remark);
        sendMessageRequestDto.setData(dataDetail);
        return sendMessageRequestDto;
    }
}
