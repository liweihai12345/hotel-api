package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动产品抢购实体
 * 表名 activity_snap_up
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-11 16:36:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRecordDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //编号
    private Integer id;
    //产品编号
    private Integer aid;

    private Long uid;
    //活动编号
    private Integer pid;
    //产品名称
    private String name;
    //价格
    private String orderNo;

    private Date createDate;

}
