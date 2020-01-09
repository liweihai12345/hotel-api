package com.platform.mapper;


import com.platform.entity.IncomeCoinDO;
import com.platform.vo.EnergyCoinVO;
import com.platform.vo.IncomeListVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface IncomeCoinMapper extends BaseDao<IncomeCoinDO> {

    List<IncomeCoinDO> queryCountRecord(@Param("uid") Long uid, @Param("type") Integer type, @Param("date") String date);

    BigDecimal selectTotalCount(@Param("uid") Long uid, @Param("type") Integer type, @Param("date") String date);

    List<IncomeListVO> queryListRecord(Map<String, Object> map);

    List<EnergyCoinVO> totalDetail();


    List<EnergyCoinVO> selectIncomeCoinList(@Param("uid") Long uid,
                                            @Param("begin") String begin,
                                            @Param("end") String end,
                                            @Param("start") Integer start,
                                            @Param("size") Integer size);

    BigDecimal selectIncomeCoinInSum(@Param("uid") Long uid,
                                     @Param("begin") String begin,
                                     @Param("end") String end);

}
