package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 商城_用户级别
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleJobLogDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long logId;
    private Long jobId;
    private String beanName;
    private String methodName;
    private String params;
    private Integer status;
    private String error;
    private Long times;
    private Date createTime;


}
