package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description: 月成本明细
 * @Author: liweihai
 * @Date: Created in 2019/3/9 11:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostListVO {

    private String costType;
    private String costTypeName;//成本类型名
    private String settleType;//结算类型
    private String settleTypeName;//结算类型名
    private String amount;//金额
    private String createDate;

}
