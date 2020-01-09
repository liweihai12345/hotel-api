package com.platform.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论信息
 * @author wolf
 * @Date   2018年12月14日 上午11:05:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO implements Serializable{

	private static final long serialVersionUID = 1893422456219966468L;
	private Integer id;//评论编号
	private Integer studyVideoId;//视频id
	private Long partnerId;//评论人id
	private String partnerName;//评论人名称
	private String partnerHead;//评论人头像
	private String msg;//评论内容
    @JsonSerialize(using = DateToLongSerializer.class)
	private Date createTime;//评论时间 yy/MM/dd
}
