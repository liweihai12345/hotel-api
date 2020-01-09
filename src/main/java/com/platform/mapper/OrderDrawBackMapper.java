package com.platform.mapper;

import com.platform.entity.OrderDrawbackDO;
import org.apache.ibatis.annotations.Param;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/4/24 17:43
 */
public interface OrderDrawBackMapper {

    int insert(OrderDrawbackDO drawback);

    OrderDrawbackDO selectDrawback(@Param("orderno") String orderno);
}
