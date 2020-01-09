package com.platform.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platform.config.json.DateToLongSerializer;
import com.platform.entity.SpreadRankDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 排行榜基本信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> bannerUrl; // banner链接地址
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date endTime; // 截止日期，格式MM月dd日
    private int myRank; // 我的名次
    private int myRankCount; // 我的团队数量
    private List<SpreadRankDO> items; // 排名数据


}
