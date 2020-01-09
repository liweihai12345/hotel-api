package com.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer proId;
    private Integer styleId;
    private String commentImg;
    private String content;

}
