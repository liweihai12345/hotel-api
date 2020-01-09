package com.platform.mapper;

import com.platform.entity.UserDynamicCollectDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/13 13:50
 */
public interface UserDynamicCollectMapper extends BaseDao<UserDynamicCollectDO> {

    Integer selectCollectNum(@Param("userId") Long userId);

    Boolean checkCollect(@Param("userId") Long userId, @Param("dynamicId") Long dynamicId);

    Integer insertCollect(@Param("userId") Long userId, @Param("dynamicId") Long dynamicId);

    Integer deleteCollect(@Param("userId") Long userId, @Param("dynamicId") Long dynamicId);

    List<Long> selectCollectIds(@Param("userId") Long userid);
}
