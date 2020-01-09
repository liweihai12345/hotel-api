package com.platform.mapper;

import com.platform.entity.StudyDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
@Mapper
public interface StudyMapper extends BaseDao<StudyDO> {

    List<StudyDO> selectListForType(@Param("type") int type, @Param("start") int start, @Param("size") int size);

    List<StudyDO> selectListForTypes(@Param("list") List<Integer> list, @Param("start") int start, @Param("size") int size);

    StudyDO selectBgimg(@Param("type") int type);

    StudyDO selectObjectByType(@Param("type") int type);
}
