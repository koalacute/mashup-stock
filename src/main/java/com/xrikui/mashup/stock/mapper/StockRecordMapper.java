package com.xrikui.mashup.stock.mapper;

import com.xrikui.mashup.stock.entity.StockRecord;
import com.xrikui.mashup.stock.entity.StockRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRecordMapper {
    long countByExample(StockRecordExample example);

    int deleteByExample(StockRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StockRecord record);

    int insertSelective(StockRecord record);

    List<StockRecord> selectByExample(StockRecordExample example);

    StockRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StockRecord record, @Param("example") StockRecordExample example);

    int updateByExample(@Param("record") StockRecord record, @Param("example") StockRecordExample example);

    int updateByPrimaryKeySelective(StockRecord record);

    int updateByPrimaryKey(StockRecord record);
}