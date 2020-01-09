package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/3/18 13:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TextConfigVO {
    private Integer id;
    private String title;
    private String content;
    private String bottom;
    private Integer type;
    private String comment;
    private String htmlComment;
    private String nodone;
    private String done;
    private Integer status;

}
