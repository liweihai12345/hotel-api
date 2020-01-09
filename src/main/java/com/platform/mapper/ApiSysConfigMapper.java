package com.platform.mapper;


import com.platform.vo.SysConfigVO;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface ApiSysConfigMapper extends BaseDao<SysConfigVO> {
    /**
     * 根据key，查询value
     */
    String queryByKey(String paramKey);


}
