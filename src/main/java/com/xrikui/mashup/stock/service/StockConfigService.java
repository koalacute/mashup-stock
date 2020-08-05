package com.xrikui.mashup.stock.service;

import cn.hutool.core.date.DateUtil;
import com.xrikui.mashup.common.constant.CharConstant;
import com.xrikui.mashup.common.service.RestTemplateService;
import com.xrikui.mashup.common.utils.BigDecimalUtils;
import com.xrikui.mashup.common.utils.DateTimeUtils;
import com.xrikui.mashup.stock.entity.StockConfig;
import com.xrikui.mashup.stock.entity.StockConfigExample;
import com.xrikui.mashup.stock.entity.StockRecord;
import com.xrikui.mashup.stock.mapper.StockConfigMapper;
import com.xrikui.mashup.stock.mapper.StockRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockConfigService {

    @Autowired
    private MashupConfigService mashupConfigService;
    @Autowired
    private RestTemplateService restTemplateService;
    @Autowired
    private StockConfigMapper stockConfigMapper;
    @Autowired
    private StockRecordMapper stockRecordMapper;


    /**
     * 根据启用标识查询全部配置
     *
     * @param mark 启用标识
     * @return
     */
    public List<StockConfig> findAllStockConfig(String mark) {
        StockConfigExample stockConfigExample = new StockConfigExample();
        stockConfigExample.createCriteria().andStockMarkEqualTo(mark);
        return stockConfigMapper.selectByExample(stockConfigExample);
    }


    /**
     * 查询 && 通知
     *
     * @param stockConfigList 股票配置
     */
    public void loop(List<StockConfig> stockConfigList) {
        String baseUrl = mashupConfigService.findConfigByName("sinajs");
        stockConfigList.forEach(stockConfig -> {
            StockRecord stockRecord = handlerRestContent(rest(baseUrl, stockConfig));
            if (null != stockRecord) {
                stockRecordMapper.insertSelective(stockRecord);
            }
            // 发送通知
            System.out.println("我已发送通知");
        });
    }


    /**
     * 处理返回内容
     *
     * @param restContent
     */
    private StockRecord handlerRestContent(String restContent) {
        int index = restContent.indexOf('"');
        if (-1 == index) {
            return null;
        }
        String[] splitList = restContent.substring(index + 1, restContent.length() - 2).split(CharConstant.DOU_HAO);
        StockRecord stockRecord = new StockRecord();
        stockRecord.setName(splitList[0]);
        stockRecord.setTodayDate(DateUtil.format(new Date(), DateTimeUtils.yyyyMMdd));
        stockRecord.setTodayOpenPrice(BigDecimalUtils.transform(splitList[1]));
        stockRecord.setYesterdayClosePrice(BigDecimalUtils.transform(splitList[2]));
        stockRecord.setCurrentPrice(BigDecimalUtils.transform(splitList[3]));
        stockRecord.setTodayHighestPrice(BigDecimalUtils.transform(splitList[4]));
        stockRecord.setTodayLowestPrice(BigDecimalUtils.transform(splitList[5]));
        return stockRecord;
    }


    /**
     * 发起请求
     *
     * @param baseUrl     基础地址
     * @param stockConfig 股票配置
     * @return
     */
    public String rest(String baseUrl, StockConfig stockConfig) {
        return restTemplateService.get(baseUrl + stockConfig.getStockCode(), String.class);
    }
}
