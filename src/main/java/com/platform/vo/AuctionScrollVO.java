package com.platform.vo;

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
public class AuctionScrollVO implements Serializable {

    private static final long serialVersionUID = 4577832207334162112L;
    private Integer bid;
    private String phone;
    private Integer id;


}
