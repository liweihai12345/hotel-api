package com.platform.mapper;

import com.platform.vo.HtmlConfigVO;
import org.apache.ibatis.annotations.Param;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/16 17:05
 */
public interface ApiHtmlConfigMapper {
    HtmlConfigVO queryObjectForType(@Param("type") Integer type);
}
