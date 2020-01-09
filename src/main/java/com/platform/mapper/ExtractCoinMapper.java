package com.platform.mapper;

import com.platform.entity.AddressDO;
import com.platform.entity.ExtractCoinDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface ExtractCoinMapper extends BaseDao<ExtractCoinDO> {

    BigDecimal selectTotal();

    int check(@Param("userId") Long userId,@Param("begin") String begin,@Param("end") String end);
}
