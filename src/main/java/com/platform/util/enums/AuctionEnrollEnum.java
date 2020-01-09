package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum AuctionEnrollEnum {
    IS_ENROLL(0, "报名"),
    IS_BACK(1, "返还"),
    IS_PAY(2, "消费");

    private int key;
    private String value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    AuctionEnrollEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public static String getValue(int key) {
        for (AuctionEnrollEnum ec : values()) {
            if(ec.getKey() == key)
                return ec.getValue();
        }
        return null;
    }
}
