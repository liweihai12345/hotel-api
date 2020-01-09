package com.platform.mapper;

import com.platform.vo.VersionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 版本信息dao
 */
public interface ApiVersionMapper extends BaseDao<VersionVO> {

    /**
     * 根据ID获取版本信息
     *
     * @param id 编号
     * @return
     */
    public VersionVO getVersionById(@Param("id") Integer id);

    /**
     * 根据版本类型获取版本列表
     *
     * @param type 安卓或ios
     * @return
     */
    public VersionVO fetchVersionList(@Param("type") Integer type);
}
