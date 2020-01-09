package com.platform.mapper;

import com.platform.entity.AuctionRecordDO;
import com.platform.vo.AuctionRecordVO;
import com.platform.vo.AuctionScrollVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 竞拍记录Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-05 13:51:24
 */
public interface AuctionRecordMapper extends BaseDao<AuctionRecordDO> {

    int checkCount(@Param("uid") Long uid, @Param("aid") Integer aid);

    List<AuctionScrollVO> selectScrollTop(@Param("aid") Integer aid);

    Integer selectProductLatest(@Param("aid") Integer aid);

    List<AuctionRecordVO> selectAuctionRecordList(@Param("aid")Integer aid,@Param("start") Integer start, @Param("size")Integer size);

    List<AuctionRecordDO> selectHighest(@Param("aid")Integer aid,@Param("maximum") Integer maximum);
}
