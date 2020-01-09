package com.platform.mapper;

import com.platform.dto.TeamUserDTO;
import com.platform.entity.SpreadRankDO;
import com.platform.entity.TeamDO;
import com.platform.entity.TeamRecommendDO;
import com.platform.entity.TeamWithUserDO;
import com.platform.vo.MyTeamUserVO;
import com.platform.vo.TeamVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 团队信息dao
 *
 * @author wolf
 * @Date 2018年12月3日 上午10:49:04
 */
public interface ApiTeamMapper {


    //添加团队信息
    boolean addTeam(TeamDO team);

    // 获取自己的团队
    TeamWithUserDO selectMyParentTeam(@Param("uid") Long uid);

    List<SpreadRankDO> selectTeamList();

    Integer selectMyTeamCount(@Param("tid") Integer tid);

    List<MyTeamUserVO> selectTeamUserList(@Param("tid") Integer tid, @Param("index") int index, @Param("size") int size);

    //添加团队关系
    boolean addTeamWithUser(TeamWithUserDO team);


    //根据Id获取团队信息
    TeamVO selectTeamByUid(@Param("uid") Long uid);

    int bindTeamMapping(@Param("userId") Long userId, @Param("tid") Integer tid);

    Integer selectTeamBindCount(@Param("tid") Integer tid, @Param("date") String date);

    MyTeamUserVO selectParentTeamUser(@Param("tid") Integer tid);

    List<TeamUserDTO> selectParentTeamList(@Param("list") List<Integer> list);

    int checkChildTeam(@Param("myid") Long myid, @Param("userId") Long userId);

    // 团队下有多少个Done
    int selectTeamDone(@Param("tid") Integer tid);
    //团队下的用户id集合
    List<Long> selectMyTeamIdList(@Param("tid")Integer tid);
    //获取团队推荐列表
    List<TeamRecommendDO> selectTeamRecommendList(@Param("start") Integer start,@Param("size") Integer size);
}
