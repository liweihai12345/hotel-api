package com.platform.util.enums;

import java.util.Arrays;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum OrderInfoEnum {
    ORDER_NO(0, "其他"),
    ORDER_NO_PAY(1, "请尽快支付,下单成功后30分钟未支付将自动关闭."),
    ORDER_STATUS_PROGRESS(2, "商家正在打包,请耐心等待"),
    ORDER_STATUS_CANCEL(3, "订单已取消"),
    ORDER_STATUS_FINISH(4, "你的交易已完成"),
    ORDER_STATUS_CONFIRM(6, "你的包裹已到达目的地,请您注意查收."),
//    ORDER_STATUS_COMPLAINT(8, "投诉"),
//    ORDER_STATUS_RETURN(9, "退款处理"),
//    ORDER_RETURN_PROGRESS(10, "退款中"),
    ORDER_RETURN_FINISH(11, "退款完成");

    private int key;
    private String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    OrderInfoEnum(int key, String value) {
        this.key = key;

        this.value = value;
    }

    public static String getDesc(int key) {
        OrderInfoEnum result = Arrays.stream(OrderInfoEnum.values()).filter(state -> state.getKey() == key).findFirst().orElse(OrderInfoEnum.ORDER_NO);
        return result.getValue();

    }

}
