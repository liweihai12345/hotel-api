package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 搜索用户对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDynamicCollectDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private Long dynamicId;
    private Integer see;
    private Date createDate;
}
