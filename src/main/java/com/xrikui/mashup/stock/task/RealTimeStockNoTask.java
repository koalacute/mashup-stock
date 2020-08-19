package com.xrikui.mashup.stock.task;

import com.xrikui.mashup.common.utils.DateTimeUtils;
import com.xrikui.mashup.stock.entity.StockConfig;
import com.xrikui.mashup.stock.enums.StockConfigMarkEnum;
import com.xrikui.mashup.stock.service.StockConfigService;
import com.xrikui.mashup.stock.service.StockSendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@Configurable
@EnableScheduling
public class RealTimeStockNoTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(RealTimeStockNoTask.class);

    private final StockConfigService stockConfigService;
    private final StockSendMessageService stockSendMessageService;

    @Autowired
    public RealTimeStockNoTask(StockConfigService stockConfigService, StockSendMessageService stockSendMessageService) {
        this.stockConfigService = stockConfigService;
        this.stockSendMessageService = stockSendMessageService;
    }

    @Scheduled(cron = "0/5 * * * * *")
    /*@Scheduled(cron = "0 0/1 9,10,11,13,14 * * ? *")*/
    public void realTimeStockNo() {

        try {
            if (!DateTimeUtils.checkTime()) {
                return;
            }

            List<StockConfig> stockConfigList = stockConfigService.findAllStockConfig(StockConfigMarkEnum.ENABLE.value);
            if (CollectionUtils.isEmpty(stockConfigList)) {
                return;
            }
            stockSendMessageService.loop(stockConfigList);
        } catch (Exception e) {
            LOGGER.error("error_message:", e);
        }
    }
}
