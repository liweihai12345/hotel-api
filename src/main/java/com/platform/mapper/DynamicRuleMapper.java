package com.platform.mapper;

import com.platform.entity.DynamicRuleDO;
import com.platform.vo.EnergyTaskVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface DynamicRuleMapper extends BaseDao<DynamicRuleDO> {

    List<DynamicRuleDO> queryRuleList(@Param("keycode") String keycode, @Param("enabled") Integer enabled);

    List<EnergyTaskVO> selectRuleList(@Param("type") Integer type);

    EnergyTaskVO selectRuleForType(@Param("type")Integer type, @Param("cate")Integer cate);

    DynamicRuleDO selectRuleForKey(@Param("keycode") String keycode, @Param("enabled") Integer enabled);
}
