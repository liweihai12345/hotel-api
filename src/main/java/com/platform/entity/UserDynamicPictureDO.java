package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片存储表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDynamicPictureDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //图片类型
    private Integer type;
    //图片存储地址
    private String picUrl;
    //  用户编号
    private Long value;
    //图片上传时间
    private Date addTime;
    //新闻id
    private Long newid;
    //排序
    private Integer sortOrder;

}
