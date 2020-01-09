package com.platform.mapper;


import com.platform.entity.SysRegionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-11-04 11:19:31
 */
public interface SysRegionMapper extends BaseDao<SysRegionDO> {

    List<SysRegionDO> selectAllArea(@Param("areaId") Integer areaId,@Param("type")  Integer type);

    SysRegionDO selectRegionById(@Param("areaId") Integer areaId);
}
