package com.platform.mapper;

import com.platform.entity.IncomeDO;
import com.platform.vo.IncomeVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface IncomeMapper extends BaseDao<IncomeDO> {

    List<IncomeVO> queryListVO(@Param("userid") Long userid, @Param("index") Integer index, @Param("size") Integer size);

    int selectInviteCount(@Param("userid") Long userid);

    BigDecimal selectTotalIncome(@Param("userId") Long userId);

    BigDecimal selectCurrency(@Param("date") String date, @Param("userId") Long userId);
}
