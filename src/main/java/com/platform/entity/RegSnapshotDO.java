package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:39
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RegSnapshotDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long startDate;
    private Integer endDate;
    private Integer regTotal;
    private Integer difference;
    private Integer doneTotal;
    private Integer normalTotal;
    private Integer doneCount;
    private Integer normalCount;
    private String snapDate;
    private Date createDate;

}
