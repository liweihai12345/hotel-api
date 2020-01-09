package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDynamicVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    //作者id
    private Long authorid;
    //作者名称
    private String authorname;
    //作者头像
    private String authorimgurl;
    //点赞数量
    private Integer praise;
    //是否点赞
    private Boolean isPraise;
    //新闻详情
    private String newdes;
    //新闻图片
    private String imageUrl;

    private Integer type;
    //创建日期
    private Date createDate;
}
