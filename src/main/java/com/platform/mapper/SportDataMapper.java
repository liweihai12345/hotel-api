package com.platform.mapper;

import com.platform.entity.SportDataDO;
import com.platform.vo.SportData;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SportDataMapper extends BaseDao<SportDataDO> {

    List<SportDataDO> selectTodyData(@Param("userId") Long userId, @Param("type") Integer type, @Param("date") String date);

    boolean checkSportTimePeriod(@Param("userId")Long userId, @Param("begin")String begin);

    List<Long> selectTodyActive(@Param("list")List<Long> ids,@Param("type") Integer type, @Param("date") String date);

    List<SportData> selectSportRecord(@Param("userId")Long userId, @Param("startIndex")Integer startIndex, @Param("size")Integer size);
}
