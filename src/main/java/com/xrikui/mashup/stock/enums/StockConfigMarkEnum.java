package com.xrikui.mashup.stock.enums;

public enum StockConfigMarkEnum {

    ENABLE("1", "启用"),
    UNABLE("0", "关闭"),
    ;

    public final String value;
    public final String desc;

    StockConfigMarkEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
