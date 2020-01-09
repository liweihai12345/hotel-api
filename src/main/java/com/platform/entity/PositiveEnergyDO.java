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
public class PositiveEnergyDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private BigDecimal energyValue;
    private BigDecimal usableValue;
    private BigDecimal longValue;
    private Date createDate;

}
