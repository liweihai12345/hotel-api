package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDynamicDO implements Serializable {
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
    //动态类型
    private Integer type;
    //新闻详情
    private String newdes;
    //新闻图片
    private String imageUrl;
    //创建日期
    private Date createdat;
    private Integer enabled;
    //是否公开
    private Integer isopen;
    private Integer collect;
    //评论数量
    private Integer comments;
    // 分类名称
    private String cateName;
    //分类编号
    private Integer cid;
    //经度
    private BigDecimal longitude;
    //维度
    private BigDecimal latitude;
    //地址描述
    private String location;

    private List<UserDynamicPictureDO> newsPiclist;

}
