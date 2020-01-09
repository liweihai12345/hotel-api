package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 竞拍结果表实体
 * 表名 auction_finish
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-05 13:51:24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionFinishDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //编号
    private Integer id;
    //用户编号
    private Long uid;
    //手机号
    private String phone;
    //产品编号
    private Integer pid;
    //产品名称
    private String pname;
    //竞拍编号
    private Integer aid;
    //竞拍价
    private Integer bid;
    //押金
    private Integer deposit;
    //状态0未支付2已支付3流拍
    private Integer status;
    //竞拍完成时间
    private Date finishTime;
    //拍卖支付截止时间
    private Date endTime;
    //创建时间
    private Date createTime;

}
