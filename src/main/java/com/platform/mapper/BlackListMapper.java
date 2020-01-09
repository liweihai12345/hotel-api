package com.platform.mapper;

import com.platform.entity.BlackListDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlackListMapper extends BaseDao<BlackListDO> {

    int check(@Param("myuid") Long myuid, @Param("uid") Long uid);

    List<BlackListDO> selectList(@Param("uid") Long userId, @Param("start") Integer start, @Param("size") Integer size);

    int delete(@Param("myuid") Long myuid, @Param("uid") Long uid);

    List<Long> selectBlackMeIds(@Param("uid") Long uid);

    List<Long> selectMyBlackList(@Param("uid") Long uid);
}
