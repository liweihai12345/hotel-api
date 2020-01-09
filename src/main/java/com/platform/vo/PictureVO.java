package com.platform.vo;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PictureVO implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Integer id;
    //图片类型
    private Integer type;
    //图片存储地址
    private String pic_url;
    //图片标志id
    private Integer value;
    //图片上传时间
    private Date add_time;
    //新闻id
    private Integer newid;


}
