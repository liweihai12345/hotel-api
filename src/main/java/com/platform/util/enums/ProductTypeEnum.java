package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/23 21:35
 */
public enum ProductTypeEnum {

    // 商品上类型：
    PRODUCT_TYPE_PRICE(1, "自营价格商品"),
    PRODUCT_TYPE_SPCEX(2, "自营兑换商品"),
    PRODUCT_TYPE_AMOUNTEX(3, "余额兑换商品"),
    PRODUCT_TYPE_DONE(4, "D-one价格商品"),
    PRODUCT_TYPE_CAR(5, "汽车产品"),
    PRODUCT_TYPE_ACTIVITY(6, "抢购产品");
    private int key;
    private String value;

    ProductTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

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


}
