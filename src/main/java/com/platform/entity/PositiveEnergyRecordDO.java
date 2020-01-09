package com.platform.entity;

import com.platform.util.BigDecimalUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.function.BinaryOperator;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PositiveEnergyRecordDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long userId;
    private Integer energyId;
    private String energyName;
    private BigDecimal energyValue;
    private Long childUserId;
    private Date createDate;

    public static final BinaryOperator<PositiveEnergyRecordDO> summation = (o1, o2) -> {
        o1.setEnergyValue(BigDecimalUtil.add(o1.getEnergyValue(), o2.getEnergyValue()));
        return o1;
    };

}
