package com.platform.entity;

import com.platform.util.CharUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamRecommendDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long uid;
    private String userName;
    private String logo;
    private String phone;
    private Integer tid;
    private Integer sortOrder;
    private Date createDate;

    public String getPhone(){
        return CharUtil.replaceSensitive(this.phone);
    }
}
