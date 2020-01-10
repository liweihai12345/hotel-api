package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 个人盈亏（毛利）
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrossProfitListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String profit;//盈利
    private String income;//收入
    private String cost;//花费
    private String createdDate;//日期

}
