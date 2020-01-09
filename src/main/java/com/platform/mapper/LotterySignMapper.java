package com.platform.mapper;

import com.platform.entity.LotteryRecordDO;
import com.platform.vo.LotterySignVO;
import com.platform.vo.LotteryVO;
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
public interface LotterySignMapper extends BaseDao<LotterySignVO> {

    int queryweekTotal();

    List<LotterySignVO> selectList(Map<String,Object> param);

    Map<String,Object> querymyweekdata(Map<String,Object> param);

}
