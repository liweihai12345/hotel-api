package com.platform.mapper;

import com.platform.dto.DataDTO;
import com.platform.entity.DynamicFocusDO;
import com.platform.entity.RecommendUserDO;
import com.platform.vo.FocusVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:47
 */
public interface DynamicFocusMapper extends BaseDao<DynamicFocusDO> {


    List<Long> selectFocus(@Param("focus") Long focus, @Param("list") List<Long> list);

    List<Long> selectFocused(@Param("list") List<Long> list, @Param("focus") Long focus);

    Integer collectNoRead(@Param("userid") Long userid, @Param("see") Integer see);

    int selectFocusCount(@Param("userid") Long userid);

    int selectCoverFocusCount(@Param("userid") Long userid);

    List<Integer> selectFocusRelation(@Param("myid") Long myid, @Param("userId") Long userId);

    int insertFocus(DynamicFocusDO focusDO);

    int deleteFocus(@Param("myid") Long myid, @Param("userId") Long userId);

    int checkFocus(@Param("myid") Long myid, @Param("userId") Long userId);

    List<FocusVO> focusList(@Param("userid") Long userid, @Param("start") int start, @Param("size") Integer size);

    int updateFocus(@Param("fid") Integer fid);

    int readFocusAll(@Param("userid") Long userid);

    List<FocusVO> userFocusList(@Param("userId") Long userId, @Param("start") int start, @Param("size") Integer size);

    List<FocusVO> focusedList(@Param("userId") Long userId, @Param("start") int start, @Param("size") Integer size);

    List<RecommendUserDO> selectRecommendUser(@Param("userId") Long uid, @Param("start") Integer start, @Param("size") Integer size);

    List<FocusVO> selectNoFocusUser(@Param("list") List<Long> uids);

    List<DataDTO> selectUserFansList(@Param("list") List<Long> list);

    int isFocus(@Param("myid") Long myid, @Param("userId") Long userId);
}
