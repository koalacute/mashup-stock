package com.xrikui.mashup.stock.service;

import com.xrikui.mashup.stock.entity.StockConfig;
import com.xrikui.mashup.stock.entity.StockConfigExample;
import com.xrikui.mashup.stock.mapper.StockConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockConfigService {

    private final StockConfigMapper stockConfigMapper;

    @Autowired
    public StockConfigService(StockConfigMapper stockConfigMapper) {
        this.stockConfigMapper = stockConfigMapper;
    }

    /**
     * 根据启用标识查询全部配置
     *
     * @param mark 启用标识
     */
    public List<StockConfig> findAllStockConfig(String mark) {
        StockConfigExample stockConfigExample = new StockConfigExample();
        stockConfigExample.createCriteria().andStockMarkEqualTo(mark);
        return stockConfigMapper.selectByExample(stockConfigExample);
    }
}
