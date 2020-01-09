package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/18 15:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnergyTaskModelVO {
    private String modelNameBig;
    private String modelNameSmall;
    private List<EnergyTaskVO> list;
}
