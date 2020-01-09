package com.platform.mapper;

import com.platform.vo.BannerVO;
import com.platform.vo.MerchantBannerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * banner信息dao
 */
public interface BannerMapper extends BaseDao<BannerVO> {


    List<BannerVO> getBannerByType(@Param("type") Integer type, @Param("viewFlag") Integer viewFlag, @Param("businessType") Integer businessType);

    List<BannerVO> selectHomeBanners( @Param("type") Integer type);

    List<String> selectHistoryRank(@Param("date") String date);

    List<MerchantBannerVO> selectMerchantBanner(@Param("mid")Integer mid);
}
