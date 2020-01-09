package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/28 15:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStyleVO {
    private Long id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private BigDecimal oldPrice;
    private Integer spcPrice;
    private BigDecimal giveEnergy; //赠送能量
    private BigDecimal spcFree; //释放能量
    private BigDecimal giveTeam; //团队奖励
    private String dimensions;//规格

    public String getGiveEnergyStr(){
        return " X "+this.giveEnergy;
    }
    public String getSpcFreeStr(){
        return " X "+this.spcFree;
    }
    public String getGiveTeamStr(){
        return " 团队购物可获得SPC {num} 个";
    }
}
