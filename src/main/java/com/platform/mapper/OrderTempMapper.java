package com.platform.mapper;

import com.platform.entity.OrderDO;
import com.platform.entity.OrdernoTempDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:46
 */
public interface OrderTempMapper extends BaseDao<OrderDO> {

    OrdernoTempDO selectOrderByNo(@Param("tempNo") String tempNo);


    Integer insertTemp(OrdernoTempDO temp);

    Integer updateTempOrder(@Param("tempNo") String tempNo);
}
