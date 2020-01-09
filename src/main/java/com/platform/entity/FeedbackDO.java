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
 * @date 2017-08-15 08:03:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;
    private Long userId;
    private String userPhone;
    private String title;
    private Integer type;
    private String business;
    private String detail;
    private String content;
    private Integer status;
    private Date createTime;

}
