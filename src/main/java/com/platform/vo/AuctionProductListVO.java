package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionProductListVO implements Serializable {
    private static final long serialVersionUID = -6292653839513119652L;
    private Integer aid; //
    private Integer id; // 商品ID
    private String name; // 产品名称
    private BigDecimal price; // 商品价格
    private BigDecimal oldPrice; // 商品价格
    private Integer spcPrice; // 商品价格
    private String describ; // 描述
    private String image; // 列表图
    private Integer number; // 图片
    //押金
    private Integer deposit;
    //报名时间
    private Date enrollStart;
    //报名结束时间
    private Date enrollEnd;
    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //起拍价
    private Integer basePrice;
    private Integer sort;

    private Integer status;



}
