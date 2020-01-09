package com.platform.util.enums;

import java.math.BigDecimal;

/**
 * @program:
 * @Description: 资产估值
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum AssetValueEnum {

    DONE_VALUE(BigDecimal.valueOf(100000),"Done估值"),
    USER_VALUE(BigDecimal.valueOf(10000),"普通用户估值"),
    ENERGY_VALUE(BigDecimal.valueOf(100),"能量值估值"),
    SPC_VALUE(BigDecimal.ONE,"SPC估值");
    private BigDecimal key;
    private String value;

    public BigDecimal getKey() {
        return key;
    }

    public void setKey(BigDecimal key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    AssetValueEnum(BigDecimal key, String value) {
        this.key = key;
        this.value = value;
    }
}
