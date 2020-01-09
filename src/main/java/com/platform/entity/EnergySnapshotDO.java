package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 每日能量发放实体
 * 表名 energy_snapshot
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-06-18 10:52:36
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnergySnapshotDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //总量
    private BigDecimal total;
    //类型
    private Integer type;
    //类型名称
    private String typeName;
    //日期
    private String snapDate;
    //创建日期
    private Date createDate;

}
