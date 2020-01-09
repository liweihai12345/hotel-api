package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 动态
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserIncomeListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long uid;// 用户编号
    private Integer incomeType;// 收入支出
    private String typeName;//类型名称
    private String amount;// 金额
    private String createDate;// 日期


}
