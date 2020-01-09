package com.platform.mapper;

import com.platform.entity.AuctionEnrollDO;
import com.platform.util.enums.AuctionEnrollEnum;
import com.platform.vo.AuctionRecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报名记录Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-05 16:02:34
 */
public interface AuctionEnrollMapper extends BaseDao<AuctionEnrollDO> {

    boolean checkEnroll(@Param("aid") Integer aid,@Param("userId") Long userId);

    List<AuctionRecordVO> selectEnrollRecordList(@Param("aid") Integer aid, @Param("start") Integer start,@Param("size")  Integer size);

    Integer selectEnrollCount(@Param("aid") Integer aid);

    List<Long> selectEnrollBackList(@Param("aid") Integer aid);

    int updateStatus(@Param("list")List<Long> list,@Param("status") Integer status);

    int updateEnrollStatus(@Param("aid") Integer aid,@Param("uid") Long uid,@Param("status") Integer status);
}
