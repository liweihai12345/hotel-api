package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * banner信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerDO implements Serializable {
    private static final long serialVersionUID = 3049893080250302860L;
    private Integer id;
    private Integer type ;
    private String msg;
    private String fileUrl;
    private boolean viewFlag;
    private Integer business;
    private Integer businessType;
    private Date createTime;
    private String word;

}
