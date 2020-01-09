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
public class ActivitySnapUpDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //编号
    private Integer id;
    //产品编号
    private Integer pid;
    //产品名称
    private String name;
    //价格
    private BigDecimal price;
    //spc价格
    private Integer spcPrice;
    //原价格
    private BigDecimal oldPrice;
    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //数量
    private Integer number;
    //销售数量
    private Integer sales;
    //状态
    private Integer status;
    //类型
    private Integer type;
    //
    private Date createDate;

}
