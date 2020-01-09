package com.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 动态
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataDTO implements Serializable {

    private static final long serialVersionUID = 4577832207334162112L;
    private Integer total;
    private Long did;



}
