package com.xrikui.mashup.stock.service;

import com.xrikui.mashup.stock.entity.StockRecord;
import com.xrikui.mashup.stock.entity.StockRecordExample;
import com.xrikui.mashup.stock.mapper.StockRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class StockRecordService {

    @Autowired
    private StockRecordMapper stockRecordMapper;

    public StockRecord findLastStockRecord(String name) {
        StockRecordExample stockRecordExample = new StockRecordExample();
        stockRecordExample.createCriteria().andNameEqualTo(name);
        stockRecordExample.setOrderByClause("id desc");
        List<StockRecord> stockRecordList = stockRecordMapper.selectByExample(stockRecordExample);
        if (CollectionUtils.isEmpty(stockRecordList)) {
            return null;
        }
        return stockRecordList.get(0);
    }
}
