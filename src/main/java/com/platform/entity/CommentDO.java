package com.platform.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:40
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CommentDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;//评论编号
    private Integer studyVideoId;//视频id
    private Long partnerId;//评论人id
    private String msg;//评论内容
    private Integer type;//评论内容
    private String imgUrl;
    private Date createTime;//评论时间 yy/MM/dd
    private String userLogo;//评论时间 yy/MM/dd
    private String userName;//评论时间 yy/MM/dd

}
