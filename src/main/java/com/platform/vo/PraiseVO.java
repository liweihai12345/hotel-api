package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PraiseVO implements Serializable {
    private Long uid;
    private String name;
    private String logo;
    private Integer see;
    private Integer type;
    private Long did;//动态编号
    private String newdes;
    private String imageUrl;
    private Date createDate;
    private Long id;//点赞编号



}
