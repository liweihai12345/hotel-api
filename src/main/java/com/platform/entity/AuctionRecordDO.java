package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 竞拍记录实体
 * 表名 auction_record
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-05 13:51:24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionRecordDO implements Serializable {
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
    //竞拍价
    private Integer bid;
    //创建时间
    private Date createDate;

}
