package com.platform.mapper;

import com.platform.dto.IncomeCoinDTO;
import com.platform.entity.EnergyCoinDO;
import com.platform.entity.EnergySnapshotDO;
import com.platform.vo.EnergyCoinVO;
import com.platform.vo.IncomeListVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface EnergyCoinMapper extends BaseDao<EnergyCoinDO> {


    List<IncomeListVO> queryListRecord(Map<String, Object> map);

    List<EnergyCoinDO> queryCountRecord(@Param("uid") Long uid, @Param("type") Integer type, @Param("date") String date);

    BigDecimal selectTotalCount(@Param("uid") Long uid, @Param("type") Integer type, @Param("date") String date);
    //查看列表
    List<EnergyCoinVO> selectEnergyCoinList(@Param("uid") Long uid,
                                            @Param("begin") String begin,
                                            @Param("end") String end,
                                            @Param("start") Integer start,
                                            @Param("size") Integer size);

    int insert(EnergyCoinDO energyCoinDO);

    BigDecimal selectEnergyCoinInSum(@Param("uid") Long uid,
                                     @Param("begin") String begin,
                                     @Param("end") String end);

    BigDecimal selectEnergyCoinOutSum(
                          @Param("uid") Long uid,
                          @Param("begin") String begin,
                          @Param("end") String end);

    BigDecimal selectKmTotal(@Param("uid") Long uid, @Param("type") int type,@Param("date")  String date);

    int insertList(@Param("list")List<IncomeCoinDTO> list);

    int insertListForOrder(@Param("list")List<IncomeCoinDTO> list);

    List<IncomeCoinDTO> selectRewardList(@Param("maxId")Long maxId, @Param("beginDate")String beginDate, @Param("endDate")String endDate,
                                         @Param("start")int start, @Param("size")int size);
    Long selectMaxId(@Param("preDate")String preDate,@Param("endDate")String endDate);

    int selectRewardCount(@Param("maxId")Long maxId, @Param("beginDate")String beginDate, @Param("endDate")String endDate);

    List<EnergySnapshotDO> selectEveryTotal(@Param("beginDate")String beginDate, @Param("endDate")String endDate);
}
