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
public class LotteryWagerDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long uid;
    private String phone;
    private String name;
    private String imgurl;
    private Integer num;
    private String redBall;
    private Integer blueBall;
    private BigDecimal cost;
    private BigDecimal price;
    private Boolean exchange;
    private Integer level;
    private Integer type;
    private String lotteryName;
    private BigDecimal bonus;
    private String stages;
    private Date createDate;

}
