package com.platform.mapper;

import com.platform.entity.EnergySnapshotDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 每日能量发放Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-06-18 10:52:36
 */
public interface EnergySnapshotMapper extends BaseDao<EnergySnapshotDO> {

    void insertList(@Param("list")List<EnergySnapshotDO> list);

    void insertSpcList(@Param("list") List<EnergySnapshotDO> list);
}
