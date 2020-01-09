package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportFinderVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer accumulated ;//累计次数

    private Integer timeLenTotal;//总运动时长

    private BigDecimal calorieTotal;//总消耗卡路里

    private BigDecimal calorie;//上次运动消耗卡路里

    private Integer timeLen;//上次运动时长

    private BigDecimal distance;//上次运动距离

}
