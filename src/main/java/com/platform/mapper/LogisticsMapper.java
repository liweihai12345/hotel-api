package com.platform.mapper;

import com.platform.entity.LogisticsDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface  LogisticsMapper  extends BaseDao<LogisticsDO>{

    List<String> selectConfirmOrder(@Param("startDate")String startDate);

    int updateStatuOnFinsh(@Param("list") List<String> list);
}
