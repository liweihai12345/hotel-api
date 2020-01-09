package com.platform.mapper;

import com.platform.entity.CommentDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:26
 */
public interface VideoCommentMapper extends BaseDao<CommentDO> {

    List<CommentDO> getCommentList(@Param("vid") Integer vid, @Param("type") Integer type, @Param("size") Integer size, @Param("startIndex") int startIndex);
}
