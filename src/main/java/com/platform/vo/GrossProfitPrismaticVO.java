package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  个人毛利柱状图
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrossProfitPrismaticVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int i;

}
