package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 合伙人信息表
 *
 * @author wolf
 * @Date 2018年12月3日 上午10:04:20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendUserDO implements Serializable {

    private static final long serialVersionUID = -5416286708432554727L;
    private Long uid;
    private Long did;
    private Integer number;

}
