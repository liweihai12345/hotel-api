package com.platform.service;

import com.platform.entity.InviteDO;
import com.platform.mapper.InviteMapper;
import com.platform.util.DateUtils;
import com.platform.util.enums.UpperTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/17 11:44
 */
@Service
public class InviteService {
    @Autowired
    private InviteMapper inviteMapper;


    public InviteDO selectInviteRelation(Long userId) {
        InviteDO invite = inviteMapper.selectInviteRelation(userId);
        return invite;
    }

    public boolean saveInvite(  String invitePhone, String phone) {
        InviteDO invite = new InviteDO();
        invite.setPhone(phone);
        invite.setInvitePhone(invitePhone);
        return inviteMapper.insert(invite) > 0;
    }



}
