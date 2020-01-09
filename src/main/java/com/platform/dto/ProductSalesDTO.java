package com.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/5/16 13:43
 */
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ProductSalesDTO {

    private Integer pid;
    private Integer number;
}
