package com.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 动态
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DynamicCommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long newsid;
    private Integer comments;


}
