package com.platform.mapper;

import com.platform.entity.ShopCartDO;
import com.platform.vo.ProductVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;


public interface ShopCartMapper {


    Integer deleteSelect(@Param("list") List<Integer> list);

    List<ShopCartDO> getSelectShopCart(@Param("list") List<Integer> list);

    List<ShopCartDO> selectMyShopCart(@Param("uid") Long uid);

    int updateShopCart(@Param("cartId") Integer cartId,@Param("number") Integer number);

    int selectShopCartCount(@Param("uid") Long uid);

    ShopCartDO checkShopCart(@Param("uid") Long uid,@Param("pid") Integer pid,@Param("styleid") Integer styleid,@Param("dimensions") String dimensions);

    int insert(ShopCartDO cart);

    List<Integer> selectProductIds(@Param("list") List<Integer> list);

    List<ProductVO> selectProductList(@Param("list") List<Integer> list);
}
