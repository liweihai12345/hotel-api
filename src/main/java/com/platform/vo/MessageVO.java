package com.platform.vo;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/10 17:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageVO {
    private Integer id;
    private String title;
    private String msgImg;
    private Integer type;
    private Integer pushType;
    private String detail;
    private Integer status;
    private Boolean owned;
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;
    private Long serviceTime;


}
