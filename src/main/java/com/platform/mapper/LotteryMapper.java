package com.platform.mapper;

import com.platform.entity.LotteryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 官网商户加盟表Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-04-02 18:12:09
 */
public interface LotteryMapper extends BaseDao<LotteryDO> {


    List<LotteryDO> selectList(@Param("type")Integer type);
}
