package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionRecordVO implements Serializable {

    private static final long serialVersionUID = 1561543937959557249L;
    private Long uid;
    private String phone;
    private String pname;
    private Integer bid;
    private Date createDate;


}
