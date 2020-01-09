package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicPraiseDO implements Serializable {
    //主键
    private Integer id;

    private Long newsid;

    private Long userid;

    private Integer type;
    // private Long add_time;
    private Date createDate;
    private Integer see;


}
