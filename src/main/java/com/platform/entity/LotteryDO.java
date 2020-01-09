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
public class LotteryDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer number;
    private Integer type;
    private Date beginDate;
    private Date endDate;
    private Integer level;
    private BigDecimal rate;
    private String levelName;
    private Date createDate;
    private Integer required;
    private Integer isSpc;

}
