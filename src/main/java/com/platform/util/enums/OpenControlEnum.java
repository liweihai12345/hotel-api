package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/9 12:18
 */
public enum OpenControlEnum {
    OPEN_TYPE_DONE(1,"Done商品兑换开关"),
    OPEN_TYPE_PRODUCT(2,"普通商品兑换开关"),
    OPEN_TYPE_EXTRACT(3,"闪兑开关"),
    OPEN_TYPE_DYNAMIC(4,"社区动态内容检查开关"),
    OPEN_TYPE_PLATFORM(5,"平台用户开关");
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

    OpenControlEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
