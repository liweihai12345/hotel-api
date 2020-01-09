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
public class MerchantProCategoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; //主键Id
    private String name; //分类名称
    private String frontDesc; //描述
    private Integer parentId; //上级编号
    private String imageUrl; //图片地址
    private Integer sortOrder; //排序值
    private Date createDate; //创建时间
    private Integer show; //0不显示1显示
    private BigDecimal rate; //分类手续费
    private Integer merchant_id; //商户Id
}
