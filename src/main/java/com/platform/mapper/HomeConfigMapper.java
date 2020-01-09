package com.platform.mapper;

import com.platform.entity.HomeConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-03-09 10:01:24
 */
public interface HomeConfigMapper extends BaseDao<HomeConfigDO> {
    List<HomeConfigDO> selectListForType(@Param("type") Integer type);
}
