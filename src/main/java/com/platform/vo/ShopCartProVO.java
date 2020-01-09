package com.platform.vo;

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
public class ShopCartProVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long uid;
    private Integer pid;
    private String pname;
    private Integer styleid;
    private String styleName;
    private String styleUrl;
    private String dimensions;
    private String description;
    private Integer number;
    private BigDecimal price;
    private Integer spcPrice;
    private Date createDate;
    private BigDecimal giveEnergy; //赠送能量
    private BigDecimal spcFree; //释放能量
    private BigDecimal giveTeam; //团队奖励


}
