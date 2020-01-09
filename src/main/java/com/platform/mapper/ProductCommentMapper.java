package com.platform.mapper;

import com.platform.entity.OrderCommentDO;
import com.platform.vo.ProductCommentListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCommentMapper extends BaseDao<OrderCommentDO> {

    List<ProductCommentListVO> selectCommentListByPid(@Param("proId") Integer proId, @Param("start") Integer start, @Param("size") Integer size);

    Integer insertAll(@Param("list") List<OrderCommentDO> list);

    Integer selectCommentListCount(@Param("proId") Integer proId);
}
