package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 产品表
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO implements Serializable {
	private static final long serialVersionUID = -6292653839513119652L;
	private Integer id; // 商品ID
	private String name; // 产品名称
	private String banners; // 轮播图
	private Integer type ;
	private String typeName ;
	private String productUrl; // 图片地址
	private BigDecimal price ; // 商品价格
	private BigDecimal old_price ; // 商品价格
	private Integer spcPrice ; // 商品价格
	private String describ ; // 描述
	private String image ; // 图片
	private String body ; // 内容
	private String content;//内容新
	private String other ; // 其他
	private String other1 ; // 其他
	private String other2 ; // 其他
	private int number ; // 数量
	private int statu ; // 上架标识，0未上架，1已上架
	private Date createDate; // 商品创建时间
    private Integer merchantId;
    private String merchantName;
    private String payWay;
    private Integer sales;
    private BigDecimal rate;
    private BigDecimal giveEnergy; //赠送能量
    private BigDecimal spcFree; //释放spc
    private BigDecimal giveTeam; //释放spc

}
