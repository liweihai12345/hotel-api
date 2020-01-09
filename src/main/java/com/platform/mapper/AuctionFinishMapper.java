package com.platform.mapper;

import com.platform.entity.AuctionFinishDO;
import com.platform.vo.AuctionFinishVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 竞拍结果表Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-05 13:51:24
 */
public interface AuctionFinishMapper extends BaseDao<AuctionFinishDO> {

    AuctionFinishVO selectRecordAcquire(@Param("aid") Integer aid);

    int updateStatus(@Param("aid")Integer aid, @Param("userId")Long userId,@Param("status") Integer status);

    List<AuctionFinishDO> selectList(@Param("endTime")Date endTime);

    List<AuctionFinishVO> selectFinishAuction(@Param("list")List<Integer> aids);
}
