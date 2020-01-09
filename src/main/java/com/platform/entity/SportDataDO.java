package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 运动数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportDataDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    private Long uid;
    private String name;
    private BigDecimal distance;
    private BigDecimal distanceExtra;
    private Integer timeLen;
    private BigDecimal calorie;
    private Integer type;
    private Integer isDone;
    private Date createDate;
}
