package com.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCommentParamDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderno;
    private String token;
    private List<OrderCommentDTO> list;
}
