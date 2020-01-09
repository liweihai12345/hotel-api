package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopCartVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long uid;
    private Integer mid;
    private String merchantName;
    private List<ShopCartProVO> list;
//    private BigDecimal price;
    private BigDecimal giveEnergyMul; //赠送能量倍数
    private BigDecimal spcFreeMul; //释放能量倍数
    private BigDecimal giveTeamMul; //团队倍数

}
