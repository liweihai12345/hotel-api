package com.platform.mapper;

import com.platform.entity.MerchantInviteDO;

/**
 * 官网商户加盟表Dao
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-04-02 18:12:09
 */
public interface MerchantInviteMapper extends BaseDao<MerchantInviteDO> {

    int checkPhone(String phone);

}
