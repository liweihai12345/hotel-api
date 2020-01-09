package com.platform.mapper;

import com.platform.entity.LotteryDO;
import com.platform.entity.LotteryWagerDO;
import com.platform.vo.LotteryWagerStaticsVO;
import com.platform.vo.MyLotteryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 官网商户加盟表Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-04-02 18:12:09
 */
public interface LotteryWagerMapper extends BaseDao<LotteryWagerDO> {


    List<MyLotteryVO> quermylottery(Map<String, Object> map);

    List<LotteryWagerStaticsVO> querylotterywagerstaticsbystages(Map<String, Object> map);

    List<LotteryDO> selectList(@Param("type") Integer type);
}
