package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum BannerTypeEnum {
    HOME_TYPE(1, "首页"),
;


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

    BannerTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public static BannerTypeEnum getValue(int key) {
        for (BannerTypeEnum ec : values()) {
            if(ec.getKey() == key){
                return ec;
            }
        }
        return null;
    }
}
