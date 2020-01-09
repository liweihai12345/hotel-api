package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 学习视频
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyVideoDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String msg;
    private String imgUrl;
    private String videoUrl;
    private Integer type;
    private Integer longTime;
    private Integer isShow;
    private Date createTime;

}
