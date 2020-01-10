package com.platform.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.platform.entity.HomeConfigDO;
import com.platform.mapper.HomeConfigMapper;
import com.platform.util.ListUtils;
import com.platform.util.enums.BannerTypeEnum;
import com.platform.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-03-09 10:01:24
 */
@Service
public class HomeService {
    @Autowired
    private HomeConfigMapper homeConfigMapper;
    @Autowired
    private BannerService bannerService;


    public List<HomeConfigDO> queryList(Map<String, Object> map) {
        return homeConfigMapper.queryList(map);
    }


    public Map<String, Object> selectHomeConfig(Long myid) {
        Map<String, Object> mapList = Maps.newHashMap();
        List<HomeConfigDO> list = this.queryList(null);
        List<Integer> types = ListUtils.distant(list);
        Map<Integer, List<HomeConfigDO>> map = list.stream().collect(Collectors.groupingBy(HomeConfigDO::getType));
        for (Integer type : types) {
            if (type == 1) {
                // banner轮播
                List<HomeConfigDO> models = map.get(1);
                List<Long> bids = models.stream().map(HomeConfigDO::getBussnessid).collect(Collectors.toList());
                if (!bids.isEmpty()) {

                } else {
                    mapList.put("banners", Lists.newArrayList());
                }
            } else if (type == 2) {
                //分类
                List<HomeConfigDO> models = map.get(2);
                List<Long> bids = models.stream().map(HomeConfigDO::getBussnessid).collect(Collectors.toList());
                if (!bids.isEmpty()) {

                } else {
                    mapList.put("cates", Lists.newArrayList());
                }
            } else if (type == 3) {
                //活动广告
                List<HomeConfigDO> models = map.get(3);
                List<Long> bids = models.stream().map(HomeConfigDO::getBussnessid).collect(Collectors.toList());
                if (!bids.isEmpty()) {

                } else {
                    mapList.put("advertising", Lists.newArrayList());
                }
            } else if (type == 4) {
                //推荐引导产品
                List<HomeConfigDO> models = map.get(4);
                List<ProductListVO> pros = getHomePro(models, 4);
                mapList.put("hotPro", pros);
            } else if (type == 5) {
                // 社区精选
                List<HomeConfigDO> models = map.get(5);


            } else if (type == 6) {
                //推荐引导产品
                List<HomeConfigDO> models = map.get(6);
                List<ProductListVO> pros = getHomePro(models, 6);
                mapList.put("fula", pros);
            } else if (type == 7) {
                // 推荐单品
                List<HomeConfigDO> models = map.get(7);
                List<ProductListVO> pros = getHomePro(models, 7);
                mapList.put("pros", pros);
            }
        }
        return mapList;
    }

    private List<ProductListVO> getHomePro(List<HomeConfigDO> models, Integer htype) {

        List<Long> bids = models.stream().map(HomeConfigDO::getBussnessid).collect(Collectors.toList());

        return Lists.newArrayList();

    }


    public List<BannerVO> selectHomeBanners() {

        return bannerService.selectHomeBanners(BannerTypeEnum.HOME_TYPE.getKey());
    }

    public List<NoticeVO> selectHomeNotices(Integer type) {
        return null;
    }

    public GuestRoomVO selectHomeGuestRoom() {
        return null;
    }

    public List<GuestRoomListVO> selectHomeGuestRoomHistory(String start_date, String end_date) {
        return null;
    }

    public CostVO selectHomeCost(String month_date) {
        return null;
    }

    public List<CostListVO> selectHomeCostHistory(String month_date) {
        return null;
    }

    public IncomeVO selectHomeOperatingIncome(String month_date) {

        return null;
    }

    public List<IncomeListVO> selectHomeIncomeHistory(String month_date) {
        return null;
    }

    public FinanceVO selectHomeFinance(String month_date) {
        return null;
    }

    public FinanceVO selectHomeFinanceOrderList(String month_date) {
        return null;
    }

    public List<FinanceOrderListVO> selectHomeFinanceOrder(String month_date) {
        return null;
    }

    public GrossProfitVO selectHomeGrossProfit() {
        return null;
    }

    public List<GrossProfitListVO> selectHomeGrossProfitList(String start, String end) {
        return null;
    }

    public NetIncomeVO selectHomeNetIncome(String month_date) {

        return null;
    }

    public MaintenanceVO selectHomeMaintenance() {
        return null;
    }

    public List<MaintenanceListVO> selectHomeMaintenanceList(String start, String end) {
        return null;
    }
}
