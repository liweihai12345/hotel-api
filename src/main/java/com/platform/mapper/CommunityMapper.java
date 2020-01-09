package com.platform.mapper;

import com.platform.entity.DynamicCateMappingDO;
import com.platform.vo.CommCateVO;
import com.platform.vo.DynamicVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface CommunityMapper extends BaseDao<CommCateVO> {

    List<CommCateVO> selectCateList();

    List<DynamicCateMappingDO> selectMappingList(@Param("cid") Integer cid, @Param("start") Integer start, @Param("size") Integer size);

    List<DynamicVO> selectCommunityList(@Param("list") List<Long> list);

    List<DynamicVO> selectMyFocusList(@Param("uid") Long uid, @Param("start") Integer start, @Param("size") Integer size);

    List<DynamicVO> selectCommunityDecayList(@Param("uid") Long uid, @Param("cid") Integer cid, @Param("start") Integer start, @Param("size") Integer size);

    List<DynamicVO> selectCollectVideoListForUid(@Param("start") Integer start, @Param("size") Integer size,@Param("uid") Long uid,@Param("date") Date date);

    List<DynamicVO> selectFocusVideoListForUid(@Param("start") Integer start, @Param("size") Integer size,@Param("uid") Long uid,@Param("date") Date date);

    List<DynamicVO> selectVideoListForUid(@Param("start") Integer start, @Param("size") Integer size,@Param("uid") Long uid,@Param("dynamicId") Long dynamicId,@Param("isMe")Integer isMe);

    List<DynamicVO> selectVideoListForIds(@Param("start") Integer start, @Param("size") Integer size,@Param("list") List<Long> list,@Param("dynamicId") Long dynamicId);

    List<DynamicVO> selectVideoListForCid(@Param("start") Integer start, @Param("size") Integer size,@Param("cid") Integer cid,@Param("dynamicId") Long dynamicId,@Param("isMe")Integer isMe);

    DynamicVO selectVideForDid(@Param("dynamicId") Long dynamicId);
}
