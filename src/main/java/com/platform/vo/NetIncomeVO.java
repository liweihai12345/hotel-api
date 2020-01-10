package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 个人盈亏净利
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NetIncomeVO implements Serializable {

    private static final long serialVersionUID = -5416286708432554727L;

    private String totalIncome;//我的总收益
    /**
     * 月酒店概况
     */
    private String totalAmount;//总收入（时间段范围）
    private String totalOutlay;// 总支出
    private String totalProfit;// 总盈收
    private String shareRatio;//入股占比
}
