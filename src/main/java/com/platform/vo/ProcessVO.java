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
 * @Date: Created in 2019/3/6 13:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessVO {
    private static final long serialVersionUID = -1048383089042654389L;
    private Integer id;
    private String title;
    private String description;
    private Integer statu;
    private Date createDate;
}
