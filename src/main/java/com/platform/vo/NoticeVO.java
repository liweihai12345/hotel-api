package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 动态评论
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer type;
    private String content;
    private Date createDate;



}
