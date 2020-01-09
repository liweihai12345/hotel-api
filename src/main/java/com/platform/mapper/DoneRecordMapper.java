package com.platform.mapper;

import com.platform.entity.AccountSnapshotDO;
import com.platform.entity.DoneRecordDO;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

import java.math.BigDecimal;
import java.util.List;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-28 16:49:31
 */
public interface DoneRecordMapper extends BaseDao<DoneRecordDO> {

    DoneRecordDO selectDoneRecord(@Param("uid")Long uid, @Param("snapDate")String snapDate);

    int insert(DoneRecordDO record);

    int update(@Param("uid")Long uid, @Param("snapDate")String snapDate);

    List<Long> selectDoneRecordList(@Param("snapDate")String snapDate,@Param("total") Integer total);
}
