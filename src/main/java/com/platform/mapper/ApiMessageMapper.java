package com.platform.mapper;

import com.platform.vo.MessageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 合伙人信息
 *
 * @author wolf
 * @Date 2018年12月30日 上午10:33:25
 */
public interface ApiMessageMapper extends BaseDao<MessageVO>{

    List<MessageVO> queryMessageList(@Param("startIndex") Integer index, @Param("size") Integer size);

    MessageVO selectMessage();

    Boolean  checkMessage(@Param("userId") Long userId, @Param("mid") Integer mid, @Param("type") Integer type);

    int saveMessageMapping(@Param("mid") Integer mid, @Param("userId") Long userId, @Param("type") Integer type);

}
