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
@AllArgsConstructor
@NoArgsConstructor
public class ShopCartDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long uid;
    private Integer pid;
    private String pname;
    private String proUrl;
    private Integer type;
    private Integer styleid;
    private String styleName;
    private String styleUrl;
    private String description;
    private Integer mid;
    private String merchantName;
    private Integer number;
    private BigDecimal price;
    private Integer spcPrice;
    private BigDecimal oldPrice;
    private BigDecimal rate;
    private BigDecimal giveEnergy;//赠送spc能量
    private BigDecimal spcFree;//释放能量SPC
    private BigDecimal giveTeam;//释放能量SPC
    private String dimensions;//规格
    private Date createDate;

}
