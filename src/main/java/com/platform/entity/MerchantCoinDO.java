package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantCoinDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //交易编号
    private String tradeNo;
    //商家编号
    private Integer mid;
    //商家用户编号
    private Long uid;
    //商家手机号
    private String phone;
    //币数量
    private BigDecimal sportCoin;

    private BigDecimal coin;
    //兑换人id
    private Long consumUid;
    //兑换人手机号
    private String consumPhone;
    //产品编号
    private Integer pid;
    //产品名称
    private String productName;
    //手续费
    private BigDecimal rateValue;
    //手续费率
    private BigDecimal rate;
    //1兑换
    private Integer type;
    //状态 0无效1有效
    private Integer statu;
    //创建时间
    private Date createdDate;


}
