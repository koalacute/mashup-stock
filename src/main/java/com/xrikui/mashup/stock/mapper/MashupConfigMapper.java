package com.xrikui.mashup.stock.mapper;

import com.xrikui.mashup.stock.entity.MashupConfig;
import com.xrikui.mashup.stock.entity.MashupConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MashupConfigMapper {
    long countByExample(MashupConfigExample example);

    int deleteByExample(MashupConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MashupConfig record);

    int insertSelective(MashupConfig record);

    List<MashupConfig> selectByExample(MashupConfigExample example);

    MashupConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MashupConfig record, @Param("example") MashupConfigExample example);

    int updateByExample(@Param("record") MashupConfig record, @Param("example") MashupConfigExample example);

    int updateByPrimaryKeySelective(MashupConfig record);

    int updateByPrimaryKey(MashupConfig record);
}