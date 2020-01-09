package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 open_controller
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-06-17 09:46:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenControlDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //开关名称
    private String name;
    //文案
    private String text;
    //是否开启(0关闭,1开启)
    private Integer enable;
    //类型(1)
    private Integer type;
    //创建时间
    private Date createDate;
}
