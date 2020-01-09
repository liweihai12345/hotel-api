package com.platform.dto;

import com.platform.util.BigDecimalUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.function.BinaryOperator;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnergyRecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer energyId;
    private Integer num;
    private BigDecimal energyValue;

    public static final BinaryOperator<EnergyRecordDTO> summation = (o1, o2) -> {
        o1.setEnergyValue(BigDecimalUtil.add(o1.getEnergyValue(), o2.getEnergyValue()));
        if (StringUtils.isEmpty(o1.getNum())) {
            o1.setNum(0);
        }
        if (StringUtils.isEmpty(o2.getNum())) {
            o2.setNum(0);
        }
        o1.setNum(o1.getNum() + 1);
        return o1;
    };


}
