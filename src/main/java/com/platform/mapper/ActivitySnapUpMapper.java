package com.platform.mapper;

import com.platform.entity.ActivityRecordDO;
import com.platform.entity.ActivitySnapUpDO;
import com.platform.vo.ActivityProductListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动产品抢购Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-07-11 16:36:53
 */
public interface ActivitySnapUpMapper extends BaseDao<ActivitySnapUpDO> {

    List<ActivityProductListVO> selectActivityProductList();

    void insertRecord(ActivityRecordDO record);

    ActivityRecordDO selectUserRecord(@Param("activeId") Integer activeId,@Param("uid") Long uid);
}
