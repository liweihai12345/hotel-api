package com.platform.mapper;

import com.platform.entity.SpreadRankDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 排名信息dao
 */
public interface SpreadRankMapper {

    /**
     * 根据排名编号获取排名信息
     *
     * @param id
     * @return
     */
    public SpreadRankDO getSpreadRankById(@Param("id") Integer id);

    /**
     * 根据条件查询排名信息
     *
     * @return
     */
    public List<SpreadRankDO> getSpreadRankList(@Param("start")Integer start,@Param("size")Integer size);

    /**
     * 添加排名信息
     *
     * @param spreadRank 排名信息
     */
     boolean updateSpreadRank(List<SpreadRankDO> spreadRank);
    boolean addSpreadRank(List<SpreadRankDO> spreadRank);
    SpreadRankDO getMyRank(@Param("uid")Long uid);

    int selectCount();

    List<SpreadRankDO> selectNoSpreadRankUser();
}
