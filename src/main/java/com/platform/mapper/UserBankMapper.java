package com.platform.mapper;

import com.platform.entity.UserBankDO;
import com.platform.vo.UserBankVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/13 13:50
 */
public interface UserBankMapper extends  BaseDao<UserBankDO>{

    List<UserBankVO> selectList(@Param("userId") Long userId);
}
