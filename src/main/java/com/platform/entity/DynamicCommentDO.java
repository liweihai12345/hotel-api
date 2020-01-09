package com.platform.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DynamicCommentDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Integer id;
    private Integer typeId;
    private Long valueId;
    private String content;
    private Integer status;
    private Long userId;
    private Integer scroe;
    private Integer see;
    private Integer isreply;
    private Long touserId;
    private String touserName;
    private Long parentId;
    private String username;
    private String userpic;
//    private List<Map<String, Object>> replyList;
    //private PartnerDO user_info;
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createDate;


}
