package com.xrikui.mashup.stock.mapper;

import com.xrikui.mashup.stock.entity.StockConfig;
import com.xrikui.mashup.stock.entity.StockConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockConfigMapper {
    long countByExample(StockConfigExample example);

    int deleteByExample(StockConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StockConfig record);

    int insertSelective(StockConfig record);

    List<StockConfig> selectByExample(StockConfigExample example);

    StockConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StockConfig record, @Param("example") StockConfigExample example);

    int updateByExample(@Param("record") StockConfig record, @Param("example") StockConfigExample example);

    int updateByPrimaryKeySelective(StockConfig record);

    int updateByPrimaryKey(StockConfig record);
}