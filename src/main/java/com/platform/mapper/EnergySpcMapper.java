package com.platform.mapper;

import com.platform.dto.IncomeCoinDTO;
import com.platform.entity.EnergyCoinDO;
import com.platform.entity.EnergySnapshotDO;
import com.platform.entity.EnergySpcDO;
import com.platform.vo.EnergyCoinVO;
import com.platform.vo.EnergySpcVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EnergySpcMapper extends BaseDao<EnergySpcDO> {

    //查看列表
    List<EnergySpcVO> selectEnergySpcList(@Param("uid") Long uid,
                                          @Param("begin") String begin,
                                          @Param("end") String end,
                                          @Param("start") Integer start,
                                          @Param("size") Integer size);

    int insert(EnergySpcDO energySpcDO);

    BigDecimal selectEnergySpcInSum(@Param("uid") Long uid,
                                    @Param("begin") String begin,
                                    @Param("end") String end);

    BigDecimal selectEnergySpcOutSum(
            @Param("uid") Long uid,
            @Param("begin") String begin,
            @Param("end") String end);

    void insertAll(@Param("list") List<EnergySpcDO> list);

    BigDecimal selectSpcTotal(@Param("uid")Long userId, @Param("type")int type, @Param("date")String date);

    List<EnergySpcDO> queryCountRecord(@Param("uid") Long uid, @Param("type") Integer type, @Param("date") String date);

    List<EnergySnapshotDO> selectEveryTotal(@Param("beginDate")String beginDate, @Param("endDate")String endDate);

    Long selectMaxId(@Param("preDate")String preDate,@Param("endDate")String endDate);

    int selectRewardCount(@Param("maxId")Long maxId, @Param("beginDate")String beginDate, @Param("endDate")String endDate);

    List<IncomeCoinDTO> selectRewardList(@Param("maxId")Long maxId, @Param("beginDate")String beginDate, @Param("endDate")String endDate,
                                         @Param("start")int start, @Param("size")int size);

    int insertList(@Param("list")List<IncomeCoinDTO> list);

    BigDecimal selectSportSpcTotal();

    BigDecimal selectTaskSpcTotal();

    BigDecimal selectMinerSpcTotal();

    BigDecimal selectShopSpcTotal();

    BigDecimal selectGiveOutSpcTotal();
}
