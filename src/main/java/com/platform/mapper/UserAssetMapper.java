package com.platform.mapper;

import com.platform.dto.UserAssetDTO;
import com.platform.entity.UserAssetDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface UserAssetMapper extends BaseDao<UserAssetDO> {

    UserAssetDO selectTotalAsset(@Param("userId") Long userId);

    int updateCoinAccount(UserAssetDO asset);

    int updateAccount(UserAssetDO asset);

    int updateUserAsset(@Param("userId") Long userId, @Param("realName") String realName);

    int updateKilometer(@Param("kmCount") BigDecimal kmCount, @Param("kmExtra") BigDecimal kmExtra, @Param("real") BigDecimal real,
                        @Param("userId") Long userId, @Param("version") Integer version);

    void initAssetKm();

    List<Long> selectTotalLock();

    int releaseCoin();

    BigDecimal selectTotal();

    List<UserAssetDTO> selectUserAssetForIds(@Param("uids") List<Long> uids);

    int updateUserAssetList(@Param("list") List<UserAssetDTO> list);

    void updateAssetCoin(@Param("asset") UserAssetDTO asset);


    boolean updateAssetBackRate(@Param("uid") Long uid, @Param("backRate") BigDecimal backRate);

    void updateSpcBack(@Param("list")List<Long> list, @Param("deposit")Integer deposit);

    BigDecimal selectUserEnergyTotal();

    BigDecimal selectUserHoldTotal();
}
