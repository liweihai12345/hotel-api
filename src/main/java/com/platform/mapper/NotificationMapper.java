package com.platform.mapper;

import com.platform.entity.NotificationDO;
import com.platform.entity.NotificationRecordDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-28 16:49:31
 */
public interface NotificationMapper extends BaseDao<NotificationDO> {

    List<NotificationDO> selectNotificationList();

    NotificationRecordDO selectRecordById(@Param("id") Integer id);

    int insert(NotificationRecordDO recordDO);
}
