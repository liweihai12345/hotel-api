package com.platform.entity;

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
public class TipOffInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long uid;
    private Long tipUid;
    private String tipName;
    private String tipLogo;
    private String tipContent;
    private Long tipBissness;
    private Integer tipBissnessType;
    private Date createDate;



}
