package com.platform.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/**
 * 视频信息
 * @author wolf
 * @Date   2018年12月14日 上午11:08:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyVideoVO implements Serializable{

	private static final long serialVersionUID = -4763523039690732115L;
	private Integer id;//视频id
	private String imageUrl;//视频图片
	private String videoUrl;//视频地址
	private String title;//视频标题
	private String msg;//视频介绍内容
	private Integer type;//视频类型
	private String typeStr;//视频类型
	private  Integer duration;//时长

}
