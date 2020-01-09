package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum AuctionEnum {
    NO_PAY(0, "未支付"),
    IS_PAY(1, "已支付"),
    IN_PASS(2, "流拍");

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

    AuctionEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public static String getValue(int key) {
        for (AuctionEnum ec : values()) {
            if(ec.getKey() == key)
                return ec.getValue();
        }
        return null;
    }
}
