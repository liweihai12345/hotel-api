package com.platform.mapper;

import com.platform.entity.DynamicCateMappingDO;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface DynamicCateMappingMapper extends BaseDao<DynamicCateMappingDO> {

    int deleteDynamic(@Param("did")Long did);
}
