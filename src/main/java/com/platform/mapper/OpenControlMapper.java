package com.platform.mapper;

import com.platform.entity.OpenControlDO;
import org.apache.ibatis.annotations.Param;

/**
 * Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-06-17 09:46:05
 */
public interface OpenControlMapper extends BaseDao<OpenControlDO> {

    OpenControlDO check(@Param("type") Integer type);
}
