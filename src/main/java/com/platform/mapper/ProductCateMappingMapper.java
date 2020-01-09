package com.platform.mapper;

import com.platform.entity.ProductCateMappingDO;
import com.platform.vo.ProductListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/28 15:34
 */
public interface ProductCateMappingMapper {


    List<ProductListVO> selectMerchantPro(@Param("mid") Integer mid, @Param("parentId") Integer parentId, @Param("cateId") Integer cateId,
                                          @Param("start") Integer start, @Param("size") Integer size,@Param("sort")Integer sort);

    List<ProductListVO> selectMerchantProList(@Param("mid")Integer mid,@Param("start")Integer index,@Param("size")Integer size,@Param("sort") Integer sort);

    ProductCateMappingDO selectProductMapping(@Param("pid")Integer pid);
}
