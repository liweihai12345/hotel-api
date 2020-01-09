package com.platform.util.enums;

import java.util.Arrays;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum OrderStatusEnum {
    ORDER_NO(0, "出错了"),
    ORDER_STATUS_BEGIN(1, "待支付"),
    ORDER_STATUS_PROGRESS(2, "支付成功"),
    ORDER_STATUS_CANCEL(3, "已取消"),
    ORDER_STATUS_FINISH(4, "已完成"),
    ORDER_STATUS_NOSEND(5, "待发货"),
    ORDER_STATUS_CONFIRM(6, "待签收"),
    ORDER_STATUS_COMPLAINT(8, "投诉"),
    ORDER_STATUS_RETURN(9, "退款处理"),
    ORDER_RETURN_PROGRESS(10, "退款中"),
    ORDER_RETURN_FINISH(11, "退款完成");

    private int key;
    private String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    OrderStatusEnum(int key, String value) {
        this.key = key;

        this.value = value;
    }

    public static String getDesc(int key) {
        OrderStatusEnum result = Arrays.stream(OrderStatusEnum.values()).filter(state -> state.getKey() == key).findFirst().orElse(OrderStatusEnum.ORDER_NO);
        return result.getValue();

    }

}
