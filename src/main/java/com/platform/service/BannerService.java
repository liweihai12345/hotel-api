package com.platform.service;

import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.mapper.BannerMapper;
import com.platform.vo.BannerVO;
import com.platform.vo.MerchantBannerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * banner事务层
 */
@Service("bannerService")
public class BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private RedisUtil redisUtil;


    /**
     * 通过显示区域查询banner信息
     *
     * @param type     类型1商城6排行,7行业案例'
     * @param viewFlag 显示标识：0不显示，1显示
     * @return banner访问链接
     */
    public List<BannerVO> getBannerByType(Integer type, Integer viewFlag, Integer businessType) {

        return bannerMapper.getBannerByType(type, viewFlag, businessType);
    }

    public List<BannerVO> selectHomeBanners( Integer type) {
        List<BannerVO> list = (List<BannerVO>) redisUtil.get(Constants.REDIS_HOME_BANNER + type);
        if (list == null || list.isEmpty()) {
            list = bannerMapper.selectHomeBanners( type);
            redisUtil.set(Constants.REDIS_HOME_BANNER + type, list, 3600);
        }
        return list;
    }

    public List<String> selectHistoryRank(String date) {
        return bannerMapper.selectHistoryRank(date);
    }

    //查询商户轮播图
    public List<MerchantBannerVO> selectMerchantBanner(Integer mid) {

        return bannerMapper.selectMerchantBanner(mid);
    }
}
