package com.xrikui.mashup.stock.task;

import com.xrikui.mashup.stock.entity.StockConfig;
import com.xrikui.mashup.stock.enums.StockConfigMarkEnum;
import com.xrikui.mashup.stock.service.StockConfigService;
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

    @Autowired
    private StockConfigService stockConfigService;

    @Scheduled(cron = "0/30 * * * * *")
    /*@Scheduled(cron = "0 0/1 9,10,11,13,14 * * ? *")*/
    public void realTimeStockNo() {
        LOGGER.info("【实时股价通知】 任务启动");

        try {
            List<StockConfig> stockConfigList = stockConfigService.findAllStockConfig(StockConfigMarkEnum.ENABLE.value);
            if (CollectionUtils.isEmpty(stockConfigList)) {
                LOGGER.info("【实时股价通知】 当前无股票配置,任务停止");
                return;
            }
            stockConfigService.loop(stockConfigList);
        } catch (Exception e) {
            LOGGER.error("【实时股价通知】 查询过程发生异常:", e);
        }
    }
}
