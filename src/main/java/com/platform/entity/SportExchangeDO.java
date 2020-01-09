package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 运动链配置类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportExchangeDO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;
    private String exNo;
    private Long userId;
    private String userName;
    private BigDecimal exData;
    private BigDecimal exRate;
    private Integer exType;
    private Integer exStatus;
    private Date createDate;


}
