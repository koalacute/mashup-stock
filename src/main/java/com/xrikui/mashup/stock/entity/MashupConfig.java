package com.xrikui.mashup.stock.entity;

import java.util.Date;

public class MashupConfig {
    private Long id;

    private String mashupName;

    private String mashupValue;

    private String mashupDesc;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMashupName() {
        return mashupName;
    }

    public void setMashupName(String mashupName) {
        this.mashupName = mashupName == null ? null : mashupName.trim();
    }

    public String getMashupValue() {
        return mashupValue;
    }

    public void setMashupValue(String mashupValue) {
        this.mashupValue = mashupValue == null ? null : mashupValue.trim();
    }

    public String getMashupDesc() {
        return mashupDesc;
    }

    public void setMashupDesc(String mashupDesc) {
        this.mashupDesc = mashupDesc == null ? null : mashupDesc.trim();
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