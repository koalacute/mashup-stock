package com.xrikui.mashup.stock.entity;

import java.math.BigDecimal;
import java.util.Date;

public class StockRecord {
    private Long id;

    private String name;

    private BigDecimal currentPrice;

    private String nowRate;

    private String lastRate;

    private String todayDate;

    private BigDecimal todayOpenPrice;

    private BigDecimal todayHighestPrice;

    private BigDecimal todayLowestPrice;

    private BigDecimal yesterdayClosePrice;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getNowRate() {
        return nowRate;
    }

    public void setNowRate(String nowRate) {
        this.nowRate = nowRate == null ? null : nowRate.trim();
    }

    public String getLastRate() {
        return lastRate;
    }

    public void setLastRate(String lastRate) {
        this.lastRate = lastRate == null ? null : lastRate.trim();
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate == null ? null : todayDate.trim();
    }

    public BigDecimal getTodayOpenPrice() {
        return todayOpenPrice;
    }

    public void setTodayOpenPrice(BigDecimal todayOpenPrice) {
        this.todayOpenPrice = todayOpenPrice;
    }

    public BigDecimal getTodayHighestPrice() {
        return todayHighestPrice;
    }

    public void setTodayHighestPrice(BigDecimal todayHighestPrice) {
        this.todayHighestPrice = todayHighestPrice;
    }

    public BigDecimal getTodayLowestPrice() {
        return todayLowestPrice;
    }

    public void setTodayLowestPrice(BigDecimal todayLowestPrice) {
        this.todayLowestPrice = todayLowestPrice;
    }

    public BigDecimal getYesterdayClosePrice() {
        return yesterdayClosePrice;
    }

    public void setYesterdayClosePrice(BigDecimal yesterdayClosePrice) {
        this.yesterdayClosePrice = yesterdayClosePrice;
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