package com.xrikui.mashup.stock.service;

import com.xrikui.mashup.stock.entity.MashupConfig;
import com.xrikui.mashup.stock.entity.MashupConfigExample;
import com.xrikui.mashup.stock.mapper.MashupConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MashupConfigService {

    private final MashupConfigMapper mashupConfigMapper;

    @Autowired
    public MashupConfigService(MashupConfigMapper mashupConfigMapper) {
        this.mashupConfigMapper = mashupConfigMapper;
    }

    /**
     * 通过配置名查询配置值
     *
     * @param configName 配置名
     */
    public String findConfigByName(String configName) {
        MashupConfigExample mashupConfigExample = new MashupConfigExample();
        mashupConfigExample.createCriteria().andMashupNameEqualTo(configName);
        List<MashupConfig> mashupConfigList = mashupConfigMapper.selectByExample(mashupConfigExample);
        if (CollectionUtils.isEmpty(mashupConfigList)) {
            return "";
        }
        return mashupConfigList.get(0).getMashupValue();
    }
}
