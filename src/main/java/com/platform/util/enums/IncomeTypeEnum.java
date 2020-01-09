package com.platform.util.enums;

import java.util.Arrays;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum IncomeTypeEnum {
    ORDER_NO(0, "信息出错了"),
    INCOME_TYPE_REG(1, "Done奖励"),
    INCOME_TYPE_SELL(2, "售出产品"),
    INCOME_TYPE_BUYEX(3, "奖金购买产品"),
    INCOME_TRANS_OUT(4, "用户转出"),
    INCOME_TRANS_IN(5, "用户转入"),
    INCOME_TRANS_BACK(6, "推荐奖励");

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

    IncomeTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValueStr(int key) {
        IncomeTypeEnum result = Arrays.stream(IncomeTypeEnum.values()).filter(state -> state.getKey() == key).findFirst().orElse(IncomeTypeEnum.ORDER_NO);
        return result.getValue();

    }
}
