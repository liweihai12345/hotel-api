package com.platform.service;

import com.platform.mapper.ApiMessageMapper;
import com.platform.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合伙人信息事务层
 */
@Service
public class MessageService {
    @Autowired
    private ApiMessageMapper apiMessageMapper;


    public List<MessageVO> queryMessageList(Integer index, Integer size) {
        int startIndex = size * (index - 1);
        return this.apiMessageMapper.queryMessageList(startIndex, size);
    }

    public MessageVO queryMessage(Integer mid) {
        return this.apiMessageMapper.queryObject(mid);
    }

    public Boolean checkIsRead(Long userId) {
        MessageVO m =apiMessageMapper.selectMessage();
        return  apiMessageMapper.checkMessage(userId,m.getId(),m.getType());
    }

    public boolean addMessageMapping(Long userId, Integer mid, Integer type) {
        return apiMessageMapper.saveMessageMapping(mid,userId,type)>0;
    }
    //获取最新一条
    public MessageVO selectMessageTop() {

        return apiMessageMapper.selectMessage();
    }
}
