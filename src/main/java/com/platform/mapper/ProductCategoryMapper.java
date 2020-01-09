package com.platform.mapper;

import com.platform.entity.ProCategoryDO;
import com.platform.vo.CostListVO;
import com.platform.vo.ProductCateVO;
import com.platform.vo.ProductStyleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/28 15:34
 */
public interface ProductCategoryMapper {

    List<ProductCateVO> selectProCateList();

    List<ProductStyleVO> selectStyleList(@Param("pid") Integer pid);

    ProductStyleVO selectStyle(@Param("sid") Integer sid);

    List<CostListVO> selectHomeCate(@Param("bids") List<Long> bids, @Param("type") Integer type);

    ProCategoryDO selectProCateById(@Param("pid")Integer pid);
}
