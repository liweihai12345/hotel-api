package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 报名记录实体
 * 表名 auction_enroll
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-05 16:02:34
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionEnrollDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //编号
    private Integer id;
    //用户编号
    private Long uid;
    //手机号
    private String phone;
    //竞拍编号
    private Integer aid;
    //产品编号
    private Integer pid;
    //产品名称
    private String pname;
    //押金
    private Integer deposit;
    //状态0报名1返还2消费
    private Integer statu;
    //创建时间
    private Date createDate;
}
