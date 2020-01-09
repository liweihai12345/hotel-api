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
public class FocusVO implements Serializable {
    private Long uid;
    private String name;
    private String logo;
    private Integer see;
    private Integer focus;//关注状态
    private Long id;
    private Integer dynamicNum;//动态数量
    private Integer fans;//动态数量
    private Date createDate;
    private String signature;


}
