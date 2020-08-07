package com.xrikui.mashup.stock.mapper.ext;

import com.xrikui.mashup.stock.entity.StockRecord;
import com.xrikui.mashup.stock.mapper.StockRecordMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRecordExtMapper extends StockRecordMapper {

    void insertByDuplicateKey(StockRecord stockRecord);
}