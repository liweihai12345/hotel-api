package com.platform.mapper;

import com.platform.entity.AccountSnapshotDO;

import java.math.BigDecimal;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-28 16:49:31
 */
public interface AccountSnapshotMapper extends BaseDao<AccountSnapshotDO> {

    BigDecimal selectTotalForTask();
}
