package com.platform.vo;


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
public class AssetValueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer dones; //Done人数
    private Integer users; //普通用户人数
    private Integer active; //当日活跃人数
    private BigDecimal value; //资产估值
    private BigDecimal spc;//spc数量
    private BigDecimal energy;//能量数量
}
