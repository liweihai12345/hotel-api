package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/3/24 5:19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinanceVO {

    private String waitSettle;//待结账
    private String operatingTotal;//营业总额
    private String surplus;//收支结余
    private String incomeAmount;//收款金额
    private String refundAmount;//退款金额
}

