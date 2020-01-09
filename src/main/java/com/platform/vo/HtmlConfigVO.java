package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/16 17:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HtmlConfigVO implements Serializable {
    private Integer id;
    private String introduct;
    private Integer business;
    private Integer type;
    private String url;

}
