package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 动态评论
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DynamicCommentVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Long valueId;//动态编号
    private Long userId;
    private String name;
    private String logo;
    private Integer parentId;//评论编号
    private Integer isreply;
    private String content;
    private Long touserId;
    private String touserName;
    private Date createDate;
    private List<DynamicCommentVO> child;

}
