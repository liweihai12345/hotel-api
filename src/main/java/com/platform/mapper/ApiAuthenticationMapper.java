package com.platform.mapper;

import com.platform.entity.UserAuthenticationDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:47
 */
public interface ApiAuthenticationMapper extends BaseDao<UserAuthenticationDO> {
    int update();

    public int insert(UserAuthenticationDO authen);

    public int insertAudit(UserAuthenticationDO authen);

    UserAuthenticationDO queryAudit(@Param("userId") Long userId);
}
