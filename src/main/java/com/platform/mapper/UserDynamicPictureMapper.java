package com.platform.mapper;

import com.platform.dto.ImageDTO;
import com.platform.entity.UserDynamicPictureDO;
import com.platform.vo.PictureVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDynamicPictureMapper extends BaseDao<UserDynamicPictureDO> {

    /**
     * 批量插入图片
     *
     * @return
     */
    int addPictures(List<UserDynamicPictureDO> list);

    List<PictureVO> selectPicture(@Param("userid") Long userid, @Param("start") Integer start, @Param("size") Integer size,@Param("type")Integer type);
    //社区列表图片
    List<ImageDTO> queryPictureList(@Param("bids") List<Long> bids);

    List<UserDynamicPictureDO> queryDynamicPicture(@Param("did") Long did);

    int deleteDynamic(@Param("did") Long did);
}
