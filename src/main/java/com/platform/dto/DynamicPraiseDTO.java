package com.platform.dto;

import com.platform.vo.DynamicCommentVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 动态
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DynamicPraiseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long newsid;
    private Long userid;



}
