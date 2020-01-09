package com.platform.service;

import com.platform.config.RedisUtil;
import com.platform.entity.PartnerDO;
import com.platform.entity.TokenEntity;
import com.platform.entity.UserAssetDO;
import com.platform.util.BigDecimalUtil;
import com.platform.util.DateUtils;
import com.platform.util.MD5Util;
import com.platform.vo.AdditionModel;
import com.platform.vo.TeamVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合伙人信息事务层
 *
 * @author wolf
 * @Date 2018年12月3日 上午11:40:16
 */
@Slf4j
@Service("userService")
public class UserService {

    @Autowired
    private PartnerService partnerService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserAssetService userAssetService;

    public AdditionModel getUserLoginInfo(PartnerDO partner, String loginToken) {
        if (StringUtils.isEmpty(loginToken)) {
            Integer version = partner.getVersion();
            String oldToken = MD5Util.MD5Encode(partner.getMobile() + partner.getId() + "version" + version, "utf-8");
            loginToken = MD5Util.MD5Encode(partner.getMobile() + partner.getId() + "version" + (version + 1), "utf-8");
            Date date = new Date();
            int value = StringUtils.isEmpty(partner.getDeviceTokens()) ? 3 : 5;
            Date expire = DateUtils.minusDateForDay(date, value);
            TokenEntity entity = TokenEntity.builder().token(loginToken).expireTime(expire).userId(partner.getId()).updateTime(date).build();
            redisUtil.setLogin(loginToken, entity, value);
            redisUtil.del(oldToken);
            partnerService.updateVersion(partner.getId());
        }

        UserAssetDO asset = userAssetService.selectUserAsset(partner.getId());
        if (asset == null) {
            UserAssetDO userAsset = UserAssetDO.builder().uid(partner.getId()).phone(partner.getMobile()).userName(partner.getName()).coin(BigDecimal.ZERO).version(1).build();
            userAssetService.insert(userAsset);
            asset = userAsset;
        }
        AdditionModel model = AdditionModel.builder().build();
        BeanUtils.copyProperties(partner, model);
        model.setBalance(String.valueOf(BigDecimalUtil.format(asset.getAmount(), 2)));
        model.setSportsChain(String.valueOf(BigDecimalUtil.format(asset.getCoin())));
        model.setToken(loginToken);

        model.setRealNameFlag(0);
        model.setTeamCount(0);
        model.setTotalCount(0);
        model.setPayFlag(!StringUtils.isEmpty(partner.getPayPassword()));
        model.setWxFlag(!StringUtils.isEmpty(partner.getWxUnionId()));
        model.setVip(partner.getIsDone());
        model.setDone(partner.getIsDone() > 0);

        model.setSpcCoin(String.valueOf(asset.getSpcCoin()));
        model.setSpcCoinFrozen(String.valueOf(asset.getSpcCoinFrozen()));
        model.setCoinFrozen(String.valueOf(asset.getCoinFrozen()));
        return model;
    }


}
