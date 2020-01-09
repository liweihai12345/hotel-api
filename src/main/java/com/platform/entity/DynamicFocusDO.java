package com.platform.entity;

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
public class DynamicFocusDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    private Long userId;
    private Long touserId;
    private Integer isAttention;
    private Integer see;
    private Integer typeId;
    private Date createDate;

}
