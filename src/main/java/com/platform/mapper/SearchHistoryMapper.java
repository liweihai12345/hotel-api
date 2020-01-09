package com.platform.mapper;

import com.platform.entity.SearchHistoryDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:46
 */
public interface SearchHistoryMapper extends BaseDao<SearchHistoryDO> {
    int deleteByUserId(@Param("user_id") Long userId);
}
