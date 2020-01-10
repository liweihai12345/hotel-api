package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 个人盈亏毛利
 *
 * @author wolf
 * @Date 2018年12月14日 上午11:05:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrossProfitVO implements Serializable {

    private static final long serialVersionUID = 1893422456219966468L;

    private String yesterdayCost;//昨日成本
    private String totalCost;//总成本
    private String totalIncome;//总收入

}
