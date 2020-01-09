package com.platform.util.enums;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/12 16:22
 */
public enum CommissionEnum {
    doneproduct("doneproduct"),//done产品
    nodoneproductnomarl("nodoneproductnomarl"),//普通非done产品
    nodoneproductdone("nodoneproductdone"),//done推done产品
    traderate("traderate");//转账手续费

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String key;

    CommissionEnum(String key) {
        this.key=key;
    }


}
