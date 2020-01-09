package com.platform.mapper;

import com.platform.dto.UserAssetDTO;
import com.platform.entity.OrderDO;
import com.platform.vo.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:46
 */
public interface OrderMapper extends BaseDao<OrderDO> {

    OrderDO selectOrderByNo(@Param("orderNo") String orderNo);

    int updatePayStatus(@Param("orderNo") String orderNo, @Param("tradeNo") String tradeNo,
                        @Param("amount") BigDecimal amount, @Param("statu") int statu,
                        @Param("payStatus") int payStatus, @Param("payDate") Date payDate);



    int updateOrderStatus(@Param("orderno") String orderno, @Param("statu") int statu, @Param("cause") String cause);


    int cancelOrderStatus(@Param("orderno") String orderno, @Param("statu") int statu, @Param("cause") String cause);

    int insert(OrderDO order);

    int cancelOrderScheduled(@Param("status") int status, @Param("cause") String cause);

    int deleteOrder(@Param("orderno") String orderno, @Param("userId") Long userId);

    int delete(@Param("orderno") String orderno, @Param("userId") Long userId);

    List<OrderDO> selectOrderByNos(@Param("list") List<String> list);

    List<OrderListVO> selectOrderList(@Param("userId") Long userId, @Param("statu") Integer status, @Param("start") Integer start, @Param("size") Integer size);

    OrderDetailVO selectOrder(@Param("orderNo") String orderNo);

    int updateStatusOnFinsh(@Param("list") List<String> list);

    int updateOrderIsComment(@Param("orderNo") String orderNo);

    List<UserAssetDTO> selectOrderAmounts(@Param("list") List<String> orderNos);


}
