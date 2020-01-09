package com.platform.mapper;

import com.platform.entity.UserBankDO;
import com.platform.entity.UserCashOutDO;
import com.platform.vo.UserCashOutVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/13 13:50
 */
public interface UserCashOutMapper extends  BaseDao<UserCashOutDO>{

    List<UserCashOutVO> selectCashList(@Param("userId") Long userId,@Param("start")Integer start,@Param("size")Integer size);
}
