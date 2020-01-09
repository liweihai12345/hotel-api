package com.platform.mapper;

import com.platform.entity.SpreadRankDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 排名信息dao
 */
public interface SpreadRankMonthMapper {


     SpreadRankDO getSpreadRankById(@Param("userId") Long userId,@Param("date") String date);

     List<SpreadRankDO> getSpreadRankList(@Param("date") String date,@Param("start") Integer start, @Param("size") Integer size);

    boolean addSpreadRank(List<SpreadRankDO> list);

    List<SpreadRankDO> selectTeamList(@Param("beginDate")String beginDate,@Param("endDate")String endDate,@Param("start") Integer start, @Param("size") Integer size);

}
