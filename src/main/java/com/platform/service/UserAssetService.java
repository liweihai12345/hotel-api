package com.platform.service;

import com.platform.config.RedisUtil;
import com.platform.dto.IncomeCoinDTO;
import com.platform.dto.TeamUserDTO;
import com.platform.dto.UserAssetDTO;
import com.platform.entity.*;
import com.platform.exception.ApiAssetException;
import com.platform.exception.ApiIncomeException;
import com.platform.mapper.UserAssetMapper;
import com.platform.mapper.UserCashOutMapper;
import com.platform.util.BigDecimalUtil;
import com.platform.util.CharUtil;
import com.platform.util.OrderNoUtils;
import com.platform.util.enums.CoinConfigEnum;
import com.platform.util.enums.CoinTypeEnum;
import com.platform.util.enums.EnergyCoinTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserAssetService {


    @Autowired
    private UserAssetMapper userAssetMapper;
    @Autowired
    private IncomeCoinConfigService incomeCoinConfigService;
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserCashOutMapper userCashOutMapper;


    public UserAssetDO selectUserAsset(Long userId) {
        UserAssetDO asset = userAssetMapper.selectTotalAsset(userId);
        return asset;
    }


    public IncomeCoinConfigDO selectCoinConfig(Long userId) {
        PartnerDO par = partnerService.getPartnerById(userId);
        int type = par.getIsDone() > 0 ? CoinConfigEnum.CONFIG_TYPE_EXD.getKey() : CoinConfigEnum.CONFIG_TYPE_EX.getKey();
        IncomeCoinConfigDO conf = incomeCoinConfigService.selectCoinConfig(type);
        return conf;
    }

    //主更新公里数
    public boolean updateKilometer(UserAssetDO a) {
        boolean result = userAssetMapper.updateKilometer(a.getKilometer(), a.getKilometerExtra(), a.getKilometerReal(), a.getUid(), a.getVersion()) > 0;
        return result;
    }

    //更新币
    public boolean updateCoinAccount(UserAssetDO a) {
        int i = userAssetMapper.updateCoinAccount(a);

        return i > 0;
    }

    // 更新金额
    public boolean updateAccount(UserAssetDO a) {
        int i = userAssetMapper.updateAccount(a);
        return i > 0;
    }

    public boolean insert(UserAssetDO asset) {
        return userAssetMapper.save(asset) > 0;
    }

    public void initAssetKm() {
        userAssetMapper.initAssetKm();
    }

    public boolean updateUserAsset(Long userId, String realName) {
        return userAssetMapper.updateUserAsset(userId, realName) > 0;
    }

    public BigDecimal selectTotal() {
        return userAssetMapper.selectTotal();
    }


    /**
     * 用户SPC转账
     *
     * @param myuid
     * @param phone
     * @param amount
     * @return
     */
    @Transactional(rollbackFor = ApiIncomeException.class)
    public boolean spcTransfer(Long myuid, String phone, BigDecimal realCoin, BigDecimal amount, BigDecimal rate, BigDecimal rateValue) {

        //我的信息
        PartnerDO myuser = partnerService.getPartnerById(myuid);
        //我的资产
        UserAssetDO myasset = userAssetMapper.selectTotalAsset(myuid);
        if (myasset.getSpcCoin().compareTo(realCoin) < 0) {
            return false;
        }
        //对方
        PartnerDO user = partnerService.getPartnerByMobile(phone);
        Long userId = user.getId();
        if (StringUtils.isEmpty(user)) {
            return false;
        }
        if (myuid.equals(user.getId())) {
            throw new ApiIncomeException("不能给自己转账", 506);
        }
        myasset.setSpcCoin(BigDecimalUtil.subtract(myasset.getSpcCoin(), realCoin));


        //对方用户资产
        UserAssetDO uasset = userAssetMapper.selectTotalAsset(user.getId());
        uasset.setSpcCoin(BigDecimalUtil.add(uasset.getSpcCoin(), amount));
        String transNo = OrderNoUtils.getTransferByUID(String.valueOf(myuid));
        //更新我的
        boolean update = this.updateCoinAccount(myasset);
        if (!update) {
            log.error("SPC转出账错误:{}", myuid);
            throw new ApiAssetException("SPC转出账错误", 506);
        }
        //更新对方用户
        boolean update1 = this.updateCoinAccount(uasset);
        if (!update1) {
            log.error("SPC转入账错误:{}", userId);
            throw new ApiAssetException("SPC转入账错误", 506);
        }

        String templateOut = CoinTypeEnum.COIN_TYPE_TRANSOUT.getValue();
        String userPhone = CharUtil.replaceSensitive(phone);
        String templateIn = CoinTypeEnum.COIN_TYPE_TRANSIN.getValue();
        String myPhone = CharUtil.replaceSensitive(myuser.getMobile());
        //添加SPC转出收益


        return true;
    }


    private IncomeCoinDTO convert(IncomeCoinDTO coin, TeamUserDTO team, BigDecimal rated, BigDecimal rate) {

        if (team == null) {
            return null;
        }
        CoinTypeEnum typeEnum = CoinTypeEnum.ENERGY_TEAM_RUN;
        coin.setType(typeEnum.getKey());
        coin.setTypeName(typeEnum.getValue());
        coin.setImage(typeEnum.getImage());
        coin.setIncomeType(0);
        coin.setDistance(BigDecimal.ZERO);
        coin.setPhone(team.getMobile());
        coin.setUid(team.getUid());
        if (team.getDone() > 0) {
            coin.setEnergyCoin(BigDecimalUtil.multiply(coin.getEnergyCoin(), rated, 5));
        } else {
            coin.setEnergyCoin(BigDecimalUtil.multiply(coin.getEnergyCoin(), rate, 5));
        }
        return coin;
    }

    // 运动挖矿
    @Transactional
    public void executeReward(List<Long> uids, Map<Long, IncomeCoinDTO> map) {

        List<UserAssetDTO> assets = userAssetMapper.selectUserAssetForIds(uids);
        for (UserAssetDTO us : assets) {
            IncomeCoinDTO inc = map.get(us.getUid());
            if (us.getDone() > 0) {
                us.setSpcCoin(BigDecimalUtil.add(us.getSpcCoin(), inc.getEnergyCoin()));
            } else {
                us.setSpcCoin(BigDecimalUtil.add(us.getSpcCoin(), inc.getEnergyCoin()));
            }
        }
        userAssetMapper.updateUserAssetList(assets);
    }


    public void updateAssetCoin(UserAssetDTO asset) {
        userAssetMapper.updateAssetCoin(asset);
    }

    /**
     * 更新释放比例
     *
     * @param userId
     * @param backRate
     */
    public void updateAssetBackRate(Long userId, BigDecimal backRate) {
        userAssetMapper.updateAssetBackRate(userId, backRate);
    }


    /**
     * 任务添加SPC能量
     *
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean exchangeEnergy(Long userId, BigDecimal energy, CoinTypeEnum typeEnum) {
        PartnerDO user = partnerService.getPartnerById(userId);
        int incomeType = 0;

        return true;
    }

    /**
     * 执行SPC赠送划转释放和团队赠送spc
     */
    public boolean executeTransferEnergy(Long userId, BigDecimal giveEnergy, BigDecimal giveTeam, int otype) {
        PartnerDO user = partnerService.getPartnerById(userId);
        boolean isFrozen = otype == 4 ? false : true;
        if (isFrozen) {
            // 添加SPC

            if (BigDecimal.ZERO.compareTo(giveEnergy) < 0) {
                UserAssetDO asset = this.selectUserAsset(userId);
                asset.setSpcCoin(BigDecimalUtil.add(asset.getSpcCoin(), giveEnergy));
                userAssetMapper.updateCoinAccount(asset);
            }
        } else {
            //解冻SPC
            // 添加SPC
            //添加SPC
            if (BigDecimal.ZERO.compareTo(giveEnergy) < 0) {
                UserAssetDO asset = this.selectUserAsset(userId);
                asset.setCoinFrozen(BigDecimalUtil.subtract(asset.getCoinFrozen(), giveEnergy));
                asset.setSpcCoin(BigDecimalUtil.add(asset.getSpcCoin(), giveEnergy));
                userAssetMapper.updateCoinAccount(asset);
            }
        }

        return true;
    }


    /**
     * 执行冻结能量赠送和待释放能量冻结
     */
    public boolean executeFrozenEnergy(Long userId, BigDecimal giveEnergy, BigDecimal giveTeam) {
        if (BigDecimal.ZERO.compareTo(giveEnergy) < 0) {
            PartnerDO user = partnerService.getPartnerById(userId);
            // 添加冻结SPC
            UserAssetDO asset = this.selectUserAsset(userId);
            //spc冻结释放
            asset.setSpcCoinFrozen(BigDecimalUtil.add(asset.getSpcCoinFrozen(), giveEnergy));
            userAssetMapper.updateCoinAccount(asset);
        }
        return true;
    }


    /**
     * 注册登录初始资产
     *
     * @param userId
     * @param mobile
     * @param name
     * @param giveEnergy
     * @param typeEnum
     */
    public void insert(Long userId, String mobile, String name, BigDecimal giveEnergy, EnergyCoinTypeEnum typeEnum) {
        if (giveEnergy.compareTo(BigDecimal.ZERO) > 0) {
        }
        //创建资产
        UserAssetDO userAsset = UserAssetDO.builder().uid(userId).phone(mobile).userName(name).spcCoin(giveEnergy).version(1).build();
        this.insert(userAsset);
    }

    /**
     * 邀请返
     *
     * @param userId
     * @param mobile
     * @param giveEnergy
     * @param inviteUid
     * @param invitePhone
     * @param inviteLogo
     * @param typeEnum
     */
    public void updateInvite(Long userId, String mobile, BigDecimal giveEnergy, Long inviteUid, String invitePhone, String inviteLogo, CoinTypeEnum typeEnum) {
        // 添加邀请人币记录
        if (giveEnergy.compareTo(BigDecimal.ZERO) > 0) {
            UserAssetDO inviteAsset = this.selectUserAsset(userId);
            inviteAsset.setSpcCoin(inviteAsset.getSpcCoin().add(giveEnergy));
            this.updateCoinAccount(inviteAsset);
        }
    }

    /**
     * 执行释放spc能量
     */
    @Transactional
    public void releaseCoin() {
        userAssetMapper.selectTotalLock();
        userAssetMapper.releaseCoin();
    }


    public boolean requestCashOut(Long userId, BigDecimal amount, String cardNo, String cardRealName, String openingBank) {

        return true;

    }

    @Transactional(rollbackFor = Exception.class)
    public boolean addCashOut(UserBankDO bank, UserAssetDO asset, PartnerDO partner, BigDecimal amount) {
        asset.setFrozen(BigDecimalUtil.add(asset.getFrozen(), amount));
        boolean result = this.updateAccount(asset);
        if (result) {
            UserCashOutDO cash = UserCashOutDO.builder().uid(partner.getId()).phone(partner.getMobile()).cashNo(OrderNoUtils.getCashByUUID(String.valueOf(partner.getId())))
                    .cardNo(bank.getCardNo()).cardBank(bank.getCardBank()).idCardNo(bank.getIdCardNo()).openBank(bank.getOpenBank())
                    .realName(bank.getRealName()).reservePhone(bank.getReservePhone()).amount(amount).build();
            return userCashOutMapper.save(cash) > 0;
        }
        return result;
    }
}