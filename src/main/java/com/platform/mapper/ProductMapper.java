package com.platform.mapper;

import com.platform.dto.ProductSalesDTO;
import com.platform.vo.ProductListVO;
import com.platform.vo.ProductVO;
import com.platform.vo.RecommendProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品信息dao
 */
public interface ProductMapper extends BaseDao<ProductVO> {


    ProductVO queryProductById(@Param("id") Integer id);

    List<ProductListVO> selectProductList(@Param("start") Integer start, @Param("size") Integer size, @Param("sort") Integer sort, @Param("type") Integer type);

    List<ProductListVO> selectHomePro(@Param("bids") List<Long> bids, @Param("htype") Integer htype);


    String selectProductWay(@Param("pid") Integer pid);

    List<ProductListVO> searchProduct(@Param("pname") String pname, @Param("start") Integer start, @Param("size") Integer size);

    List<ProductListVO> selectCateProductList(@Param("start") Integer start, @Param("size") Integer size, @Param("sort") Integer sort, @Param("cate1") Integer cate1, @Param("cate2") Integer cate2);

    int selectMerchantProCount(@Param("mid") Integer mid);

    int updateProductSales(@Param("list") List<ProductSalesDTO> list);

    List<RecommendProductVO> selectRecommendProductList(@Param("mid")Integer mid);
}
