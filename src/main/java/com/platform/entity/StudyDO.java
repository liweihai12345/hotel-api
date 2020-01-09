package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer type;
    private String typeName;
    private String title;
    private String shortTitle;
    private String introduction;
    private String name;
    private String comment;
    private String imageUrl;
    private String htmlUrl;
    private String imageHeader;
    private String imageList;
    private Integer status;
    private Integer sort;
    private Date createDate;
    private Date updateDate;

}
