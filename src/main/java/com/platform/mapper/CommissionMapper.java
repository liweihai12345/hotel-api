package com.platform.mapper;

import com.platform.entity.CommissionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:22:06
 */
public interface CommissionMapper extends BaseDao<CommissionDO> {

    List<CommissionDO> selectCommissionForKey(@Param("key") String key);

    CommissionDO selectCommission(@Param("key") String key);
}
