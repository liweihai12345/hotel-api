package com.platform.mapper;

import com.platform.entity.TaskIncomeDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface TaskIncomeMapper extends BaseDao<TaskIncomeDO> {

    List<TaskIncomeDO> selectUserTask(@Param("userId")Long userId,@Param("creditruleid") Integer creditruleid,
                                      @Param("startDate")String startDate, @Param("endDate")String endDate);

    int selectTaskTotal(@Param("userId")Long userId,@Param("creditruleid") Integer creditruleid,
                        @Param("startDate")String startDate, @Param("endDate")String endDate);
}
