package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/7/24 14:54
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoneRecordDO {
    private Integer id;
    private Integer total;
    private Long uid;
    private String snapDate;
    private Date createDate;
}
