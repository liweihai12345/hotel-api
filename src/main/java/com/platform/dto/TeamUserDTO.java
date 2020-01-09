package com.platform.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/15 17:48
 */
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class TeamUserDTO {
    private Long id;
    private Long uid;
    private String name;
    private String mobile;
    private Integer done;
    private Integer teamId;


}
