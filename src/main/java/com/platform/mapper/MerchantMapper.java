package com.platform.mapper;

import com.platform.entity.MerchantDO;
import com.platform.entity.MerchantInfoDO;
import com.platform.vo.ProductCateVO;
import com.platform.vo.RecommendStoreVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 代理商表Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-24 16:26:25
 */
public interface MerchantMapper extends BaseDao<MerchantDO> {

    int check(@Param("userId") Long userId);

    MerchantInfoDO selectMerchantInfo(@Param("mid") Integer mid);

    int addFocus(@Param("userId") Long userId, @Param("merchantId") Integer merchantId);

    int deleteFocus(@Param("userId") Long userId, @Param("merchantId") Integer merchantId);

    boolean checkFocus(@Param("userId") Long userId, @Param("merchantId") Integer merchantId);

    List<ProductCateVO> selectStoreCateByMid(@Param("merchantId") Integer merchantId);

    int updateMerchantAccount(@Param("merchantId") Integer merchantId, @Param("mamount") BigDecimal mamount);

    List<RecommendStoreVO> selectStoreFocusList(@Param("userId") Long userId, @Param("start") Integer start, @Param("size") Integer size);

    void insertMerchantAccountRecord(@Param("orderNo")String orderNo, @Param("mid")Integer mid, @Param("maccount")BigDecimal maccount, @Param("rateValue")BigDecimal rateValue);
}
