package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/9 12:18
 */
public enum TextConfEnum {
    one(1,"邀请"),
    two(2,"分享"),
    three(3,"闪兑"),
    four(4,"公司简介"),
    five(5,"基金会"),
    six(6,"行业案例");
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

    TextConfEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
