package com.platform.mapper;

import com.platform.entity.LotteryRecordDO;
import com.platform.vo.LotteryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 官网商户加盟表Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-04-02 18:12:09
 */
public interface LotteryRecordMapper extends BaseDao<LotteryRecordDO> {


    List<LotteryVO> selectLotteryList(@Param("uid") Long uid, @Param("start") int start, @Param("size") Integer size);

    List<LotteryVO> selectLotteryListbytype(@Param("uid") Long uid, @Param("start") int start, @Param("size") Integer size, @Param("type") Integer type);

    List<LotteryVO> selectLotteryScrollList(@Param("start") int start, @Param("size") Integer size);

    List<LotteryVO> selectLotteryScrollListbytype(@Param("start") int start, @Param("size") Integer size, @Param("type") Integer type);
}
