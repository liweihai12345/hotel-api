package com.platform.mapper;

import com.platform.dto.DynamicCommentDTO;
import com.platform.entity.DynamicCommentDO;
import com.platform.vo.DynamicCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:26
 */
public interface CommentMapper extends BaseDao<DynamicCommentDO> {


    /**
     * 消息-评论极速处理
     *
     * @param param
     * @return
     */
    int updateCommentById(Map<String, Object> param);

    /**
     * 新增回复
     *
     * @param commentVo
     * @return
     */
    int saveReply(DynamicCommentDO commentVo);

    int deleteAllids(@Param("list") List<Long> list);

    int deleteCommentAll(@Param("cid") Long cid);

    List<DynamicCommentVO> selectCommentForList(@Param("newid") Long newid, @Param("start") Integer start, @Param("size") Integer size);

    int selectCommentListCount(@Param("newid") Long newid);

    List<DynamicCommentVO> selectCommentAnswer(@Param("list") List<Integer> list);

    List<DynamicCommentDTO> selectDynamicCommentCount(@Param("list") List<Long> list);

    Integer commentNoRead(@Param("userId") Long userId);

    int readCommentAll(@Param("userId") Long userId);

    int updateSee(@Param("cid") Integer cid, @Param("see") int see);
}
