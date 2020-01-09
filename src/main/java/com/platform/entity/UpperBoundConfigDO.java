package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/8 3:28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpperBoundConfigDO {
    private int id;
    private int max;
    private Integer type;
}
