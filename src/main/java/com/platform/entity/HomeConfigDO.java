package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NegativeOrZero;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeConfigDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //首页模块名称
    private String modelName;
    //类型
    private Integer type;
    //类型名称
    private String typeName;
    //业务编号
    private Long bussnessid;
    //业务名称
    private String bussnessName;
    //图片
    private String imageUrl;
    private String title;
    private String describtion;
    //排序
    private Integer sort;

    private Integer status;
    //创建时间
    private Date createDate;


}
