package com.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/3/10 9:31
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
    private Long bid;
    private  String picUrl;
}
