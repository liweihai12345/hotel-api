package com.platform.mapper;

import com.platform.entity.ScheduleJobLogDO;
import org.apache.ibatis.annotations.Param;

/**
 * 商城_用户级别
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:47
 */
public interface ScheduleJobLogMapper extends BaseDao<ScheduleJobLogDO> {

    int queryJobForDate(@Param("date") String date);


    int insertJob(ScheduleJobLogDO job);
}
