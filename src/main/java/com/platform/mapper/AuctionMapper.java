package com.platform.mapper;

import com.platform.entity.AuctionDO;
import com.platform.vo.AuctionProductListVO;
import com.platform.vo.AuctionScrollVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品竞拍价Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-05 13:51:24
 */
public interface AuctionMapper extends BaseDao<AuctionDO> {

    List<AuctionDO> selectList();


    List<AuctionProductListVO> selectAuctionProductList(@Param("start") Integer start,@Param("end") Integer end);

    int updateStatus(@Param("aid") Integer aid);

    AuctionDO selectDetail(@Param("aid")Integer aid);
}
