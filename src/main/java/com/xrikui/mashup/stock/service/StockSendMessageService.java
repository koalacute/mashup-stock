package com.xrikui.mashup.stock.service;

import com.xrikui.mashup.feige.service.SendMessageService;
import com.xrikui.mashup.stock.dto.RateDto;
import com.xrikui.mashup.stock.entity.StockRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StockSendMessageService {

    @Autowired
    private StockRecordService stockRecordService;
    @Autowired
    private SendMessageService sendMessageService;

    /**
     * 处理逻辑
     *
     * @param stockRecord
     */
    public RateDto send(StockRecord stockRecord) {
        // 当前价格
        BigDecimal currentPrice = stockRecord.getCurrentPrice();
        // 今开价格
        BigDecimal todayOpenPrice = stockRecord.getTodayOpenPrice();
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
                // 则发送通知，调用通知服务
                sendMessageService.send(stockRecord.getName(), currentPrice, nowRateString, lastRateString);
            }
        }
        return rateDto;
    }
}
