package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *维护基金
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String totalIncome;//我的总收益

    private String yesterdayIncome;//昨日收入
    private String yesterdayOutlay;//昨日支出

}
