package com.platform.mapper;

import com.platform.entity.RecommendUserDO;
import com.platform.vo.RecommendStoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendUserMapper extends BaseDao<RecommendUserDO> {

    List<RecommendUserDO> selectRecommendUserList(@Param("userId") Long userId,@Param("start")Integer start,@Param("size")Integer size);

    List<RecommendStoreVO> selectRecommendStoreList(@Param("userId") Long userId,@Param("start")Integer start,@Param("size")Integer size);

    int insertNoRecommend(@Param("myId")Long myId , @Param("userId")Long userId);
}
