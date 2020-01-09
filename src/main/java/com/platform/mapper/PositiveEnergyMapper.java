package com.platform.mapper;

import com.platform.entity.PositiveEnergyDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositiveEnergyMapper extends BaseDao<PositiveEnergyDO> {


    PositiveEnergyDO selectUserEnergy(@Param("uid") Long uid);

    void updateEnergyList(@Param("list") List<PositiveEnergyDO> list);

}
