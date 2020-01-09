package com.platform.mapper;

import com.platform.dto.DataDTO;
import com.platform.entity.UserDynamicDO;
import com.platform.vo.AusleseVO;
import com.platform.vo.DynamicVO;
import com.platform.vo.RecommendDynamicVO;
import com.platform.vo.UserDynamicVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface DynamicMapper extends BaseDao<UserDynamicDO> {


    UserDynamicDO selectDynamicById(@Param("did") Long did);

    List<AusleseVO> selectHomeAuslese(Map<String, Object> map);

    DynamicVO selectDynamicDetail(@Param("newid") Long newid);

    List<DynamicVO> selectDynamicList(Map<String, Object> map);

    int modifyDynamic(Map<String, Object> map);

    int modifyComments(Map<String, Object> map);

    int updateAddCollect(Long dynamicId);

    int updateMinusCollect(Long dynamicId);

    //查询我的动态数
    Integer selectDynamicCount(@Param("userid") Long userid);

    List<DynamicVO> searchDynamicList(Map map);

    List<UserDynamicVO> selectCollectDynamicList(Map<String, Object> map);


    List<RecommendDynamicVO> selectRecommendDynamicList(@Param("userid") Long userid);

    List<DataDTO> selectUserDynamicCount(@Param("list") List<Long> list);
}
