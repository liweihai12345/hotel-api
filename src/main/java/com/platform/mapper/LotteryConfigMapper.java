package com.platform.mapper;

import com.platform.entity.LotteryConfigDO;
import com.platform.entity.LotteryDO;
import com.platform.vo.LotteryConfigVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 官网商户加盟表Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-04-02 18:12:09
 */
public interface LotteryConfigMapper extends BaseDao<LotteryDO> {



    LotteryConfigDO selectLotteryConfig(@Param("type") int type);

    List<LotteryConfigVO> selectLotteryConfigList();
}
