package com.platform.mapper;

import com.platform.entity.IncomeCoinConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:47
 */
public interface IncomeCoinConfigMapper extends BaseDao<IncomeCoinConfigDO> {

    IncomeCoinConfigDO selectCoinConfig(@Param("type") int type);

    List<IncomeCoinConfigDO> selectConfigList();
}
