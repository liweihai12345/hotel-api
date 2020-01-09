package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProCategoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer parentId;
    private String imageUrl;
    private Integer sortOrder;
    private BigDecimal rate;
    private BigDecimal energyRate; //赠送能量利率
    private BigDecimal spcFree; //释放能量费率
    private BigDecimal gaveTeam; //团队奖励
}
