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
public class ProductListVO implements Serializable {
    private static final long serialVersionUID = -6292653839513119652L;
    private Integer id; // 商品ID
    private String name; // 产品名称
    private BigDecimal price; // 商品价格
    private BigDecimal oldPrice; // 商品价格
    private Integer spcPrice; // 商品价格
    private String describ; // 描述
    private String image; // 列表图
    private Integer number; // 图片
    private String other; // 其他
    private String other1; // 其他
    private String other2; // 首页配置图
    private Date createDate;
    private Integer sort;
    private String title;
    private String modelName;
    private String describtion;
    private BigDecimal rate;
    private BigDecimal giveEnergy; //赠送能量
    private BigDecimal spcFree; //释放spc
    private BigDecimal giveTeam; //释放spc

}
