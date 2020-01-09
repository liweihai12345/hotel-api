package com.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NegativeOrZero;
import java.math.BigDecimal;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/5/23 20:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpcEnergyDTO {

    private BigDecimal rate ;
    private BigDecimal spcRateValue ;
    private BigDecimal giveEnergy ;
    private BigDecimal spcFree;
    private BigDecimal giveTeam;
}
