package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 消息通知类
 *
 * @author 李卫海 2017-06-29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRecordDO implements Serializable {

    private static final long serialVersionUID = -922547672321685255L;
    private Integer id;
    private Long uid;
    private String ticker;
    private String title;
    private String body;
    private String type;
    private String linkUrl;
    private Integer targetType;
    private Date createDate;


}
