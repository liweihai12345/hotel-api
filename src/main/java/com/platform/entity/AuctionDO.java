package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品竞拍价实体
 * 表名 auction
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-05 13:51:24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //编号
    private Integer id;
    //产品编号
    private Integer pid;
    //产品名称
    private String pname;
    //押金
    private Integer deposit;
    //报名时间
    private Date enrollStart;
    //报名结束时间
    private Date enrollEnd;
    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //起拍价
    private Integer basePrice;
    //封顶价
    private Integer cappedPrice;
    //增长倍数
    private BigDecimal multiple;
    //创建时间
    private Date createDate;
    //排序
    private Integer sort;
    private Integer statu;

}
