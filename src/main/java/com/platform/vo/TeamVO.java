package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 团队信息表
 *
 * @author wolf
 * @Date 2018年12月3日 上午9:55:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamVO implements Serializable {
    private static final long serialVersionUID = -6958502979452401684L;
    private Integer id;// 编号
    private String name;// 团队名称
    private Long uid;// 团队名称
    private Integer parentId;// 团队名称
    private Date createTime; // 创建时间

}
