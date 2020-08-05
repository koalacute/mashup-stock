package com.xrikui.mashup.stock.entity;

import java.util.Date;

public class StockConfig {
    private Long id;

    private String stockCode;

    private String stockDesc;

    private String stockMark;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getStockDesc() {
        return stockDesc;
    }

    public void setStockDesc(String stockDesc) {
        this.stockDesc = stockDesc == null ? null : stockDesc.trim();
    }

    public String getStockMark() {
        return stockMark;
    }

    public void setStockMark(String stockMark) {
        this.stockMark = stockMark == null ? null : stockMark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}