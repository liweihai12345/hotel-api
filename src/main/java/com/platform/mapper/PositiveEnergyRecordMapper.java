package com.platform.mapper;

import com.platform.dto.EnergyRecordDTO;
import com.platform.entity.PositiveEnergyRecordDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PositiveEnergyRecordMapper extends BaseDao<PositiveEnergyRecordDO> {

    Integer selectEnergyRecordCount(@Param("type") Integer type, @Param("startDate") String startDate, @Param("endDate") String endDate);

    List<PositiveEnergyRecordDO> selectEnergyRecordList(@Param("type") Integer type, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("start") Integer start, @Param("size") Integer size);

    List<EnergyRecordDTO> selectTodayEnergy(@Param("userId") Long userId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    Integer selectUserRecordCount(@Param("userId") Long userId,@Param("energyId") Integer energyId,@Param("childUserId") Long  childUserId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    int insert(PositiveEnergyRecordDO recordDO);

    BigDecimal selectUserRecordSum(@Param("userId") Long userId,@Param("energyId") Integer energyId,@Param("startDate") String startDate, @Param("endDate") String endDate);
}
