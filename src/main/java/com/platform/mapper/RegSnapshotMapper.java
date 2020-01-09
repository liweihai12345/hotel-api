package com.platform.mapper;

import com.platform.entity.RegSnapshotDO;
import com.platform.vo.RegSnapshotVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商城_用户级别
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:47
 */
public interface RegSnapshotMapper extends BaseDao<RegSnapshotDO> {

    List<RegSnapshotVO> queryRegForDate( @Param("date") String date);

    List<RegSnapshotVO> queryListForDate(@Param("start") String start, @Param("end") String end);
}
