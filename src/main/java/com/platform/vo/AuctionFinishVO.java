package com.platform.vo;

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
public class AuctionFinishVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer aid;
    //用户编号
    private Long uid;
    //手机号
    private String phone;
    //产品名称
    private String pname;
    //竞拍价
    private Integer bid;
    //押金
    private Integer deposit;
    //状态0未支付2已支付3流拍
    private Integer status;

}
