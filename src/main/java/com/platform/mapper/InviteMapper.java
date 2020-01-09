package com.platform.mapper;

import com.platform.entity.InviteDO;
import org.apache.ibatis.annotations.Param;

/**
 * 活动信息dao
 */
public interface InviteMapper {


    int insert(InviteDO invite);

    InviteDO selectInviteRelation(@Param("userId") Long userId);

    int checkInviteCount(@Param("userId") Long userId, @Param("date") String date);

    int checkInviteWXOpenId(@Param("openid")String openid);

    Integer selectInviteCount(@Param("inviteId")Long inviteId);
}
