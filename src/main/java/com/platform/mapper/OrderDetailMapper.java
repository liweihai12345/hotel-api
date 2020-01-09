package com.platform.mapper;

import com.platform.dto.ProductSalesDTO;
import com.platform.entity.OrderDetailDO;
import com.platform.vo.OrderItemVO;
import com.platform.vo.ProcessVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderDetailMapper extends BaseDao<OrderDetailDO> {

    int delete(@Param("orderno") String orderno);

    List<ProcessVO> selectProcess();

    Integer insertAll(List<OrderDetailDO> des);

    List<OrderItemVO> selectDetailForList(@Param("list") List<String> list);

    List<OrderItemVO> selectDetail(@Param("orderNo") String orderNo);

    List<OrderDetailDO> selectOrderDetailList(@Param("orderNo")String orderNo);

    List<ProductSalesDTO> selectOrderProduct(@Param("orderNo")String orderNo);
}
