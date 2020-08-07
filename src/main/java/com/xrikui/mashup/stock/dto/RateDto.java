package com.xrikui.mashup.stock.dto;

public class RateDto {

    private String nowRateString;

    private String lastRateString;

    public String getNowRateString() {
        return nowRateString;
    }

    public void setNowRateString(String nowRateString) {
        this.nowRateString = nowRateString;
    }

    public String getLastRateString() {
        return lastRateString;
    }

    public void setLastRateString(String lastRateString) {
        this.lastRateString = lastRateString;
    }
}
