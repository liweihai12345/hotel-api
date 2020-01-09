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
public class LotteryConfigDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private BigDecimal number;
    private Integer type;
    private Integer priority;
    private String user;
    private String logo;
    private Integer level;
    private BigDecimal power;
    private Date createDate;
    private Integer isOpen;

}
