package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNo;
    private Integer proId;
    private Integer key;
    private String proName;
    private String proUrl;
    private Integer cate;
    private String cateName;
    private Integer styleId;
    private String styleName;
    private String dimensions;
    private String styleUrl;
    private Integer num;
    private BigDecimal price;
    private Integer spcPrice;
    private BigDecimal rate;
    private BigDecimal rateValue;
    private String description;
    private String remark;
    private Integer type;
    private Date createDate;
    private BigDecimal giveEnergy;//赠送spc能量
    private BigDecimal spcFree;//释放能量SPC
    private BigDecimal giveTeam;//释放能量SPC
}
