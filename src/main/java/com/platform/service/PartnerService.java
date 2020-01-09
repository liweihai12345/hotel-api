package com.platform.service;

import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.entity.IncomeCoinConfigDO;
import com.platform.entity.InviteDO;
import com.platform.entity.PartnerDO;
import com.platform.exception.ApiInviteException;
import com.platform.mapper.PartnerMapper;
import com.platform.util.enums.CoinTypeEnum;
import com.platform.vo.PartnerVO;
import com.platform.vo.UserIncomeListVO;
import com.platform.vo.UserRegVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 合伙人信息事务层
 *
 * @author wolf
 * @Date 2018年12月3日 上午11:40:16
 */
@Slf4j
@Service("partnerService")
public class PartnerService {
    @Autowired
    private PartnerMapper partnerMapper;
    @Autowired
    private InviteService inviteService;
    @Autowired
    private UserAssetService userAssetService;
    @Autowired
    private IncomeCoinConfigService incomeCoinConfigService;
    @Autowired
    private RedisUtil redisUtil;


    /**
     * 根据用户编号获取用户信息
     *
     * @param id
     * @return
     */
    public PartnerDO getPartnerById(Long id) {
        PartnerDO user = (PartnerDO) redisUtil.get(Constants.REDIS_USER_KEY + ":userId" + id);
        if (StringUtils.isEmpty(user)) {
            user = partnerMapper.getPartnerById(id);
            redisUtil.setLogin(Constants.REDIS_USER_KEY + ":userId" + id, user, 5);
        }
        return user;
    }


    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    public PartnerDO getPartnerByMobile(String mobile) {
        PartnerDO user = partnerMapper.getPartnerByMobile(mobile);
        return user;
    }

    public PartnerDO getPartnerByWX(String openid) {
        PartnerDO user = partnerMapper.getPartnerByWX(openid);
        if (!StringUtils.isEmpty(user)) {
            redisUtil.setLogin(Constants.REDIS_USER_KEY + ":userId" + user.getId(), user, 5);
        }
        return user;
    }


    /**
     * 更新绑定微信信息
     *
     * @param id
     * @param openid
     * @return
     */
    public boolean bindWX(Long id, String openid) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + id);
        return this.partnerMapper.bindwx(id, openid) > 0;

    }

    public boolean unBindWX(Long id) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + id);
        return partnerMapper.unBindWX(id) > 0;

    }

    /**
     * 跟新成为done
     *
     * @return
     */
    public boolean updateDone(Long userId) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        return this.partnerMapper.updateDone(userId) > 0;
    }

    /**
     * 完善个人信息
     *
     * @param userId
     * @param name
     * @param gender
     * @param birthDate
     * @param address
     * @param signature
     */
    public int updateParterInfo(Long userId, String name, Integer gender, String birthDate, String address, String signature) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        return this.partnerMapper.updateParterInfo(userId, name, gender, birthDate, address, signature);

    }

    /**
     * 更新设备标识
     *
     * @param userId
     * @param deviceToken
     * @return
     */
    public Boolean updateDeviceToken(Long userId, String deviceToken) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        int deviceType = deviceToken.length() > 50 ? 2 : 1;
        return this.partnerMapper.updateDeviceToken(userId, deviceToken, deviceType) > 0;

    }

    /**
     * 更换手机号
     */
    public Boolean updateMobile(Long userId, String mobile, String oldMobile) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        return this.partnerMapper.updateMobile(userId, mobile, oldMobile) > 0;

    }


    /**
     * 修改支付密码
     */
    public boolean updatePayPassword(Long userId, String old, String pwd) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        return this.partnerMapper.updatePayPassword(userId, old, pwd) > 0;

    }

    /**
     * 更新合伙人头像
     *
     * @param userId     合伙人编号
     * @param pictureUrl 头像地址
     */
    public boolean updatePictureUrl(Long userId, String pictureUrl) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        return this.partnerMapper.updatePictureUrl(userId, pictureUrl) > 0;
    }

    public boolean updateUsername(Long userId, String realName) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        return this.partnerMapper.updateUsername(userId, realName) > 0;
    }


    // 消息滚动
    public List<UserRegVO> selectLatestReg() {
        List<UserRegVO> list = (List<UserRegVO>) redisUtil.get("totalCountList");
        if (list == null || list.isEmpty()) {
            int count = partnerMapper.queryTotalCountForDate(null);
            list = partnerMapper.selectLatestReg();
            for (UserRegVO vo : list) {
                vo.setPosition(count);
                count--;
            }
            redisUtil.set("totalCountList", list, 300);
        }

        list = list.stream().sorted(Comparator.comparing(UserRegVO::getPosition)).collect(Collectors.toList());
        return list;
    }


    @Transactional(rollbackFor = ApiInviteException.class)
    public boolean addInviteCoin(PartnerDO partner) {
        log.info("邀请开始返");
        //被邀请人关系
        InviteDO in = inviteService.selectInviteRelation(partner.getId());
        Long inviteId = in.getId();
        //邀请人
        PartnerDO iu = partnerMapper.getPartnerById(inviteId);

        CoinTypeEnum typeEnum = iu.getIsDone() > 0 ? CoinTypeEnum.COIN_TYPE_DONE_REG : CoinTypeEnum.COIN_TYPE_REG;
        //查询比例
        IncomeCoinConfigDO conf = incomeCoinConfigService.selectCoinConfig(typeEnum.getKey());
        this.updateInvite(partner.getId());
        //  添加邀请人币记录
        userAssetService.updateInvite(inviteId, iu.getMobile(), conf.getValue(), partner.getId(), partner.getMobile(), partner.getPictureUrl(), typeEnum);

        log.info("邀请开始返结束");
        return true;
    }

    /**
     * 修改用户背景图片
     *
     * @param param
     * @return
     */
    public int updateUserBgImg(Map<String, Object> param) {
        Long userid = Long.valueOf(param.get("userid").toString());
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userid);
        return partnerMapper.updateUserBgImg(param);
    }

    /**
     * 根据手机号查询用户详细信息
     *
     * @param phone
     * @return
     */
    public Map<String, Object> queryUserDetailsByPhone(String phone) {
        Map<String, Object> user = (Map<String, Object>) redisUtil.get(Constants.REDIS_USER_KEY + ":phone" + phone);
        if (StringUtils.isEmpty(user)) {
            user = partnerMapper.queryUserDetailsByPhone(phone);
            redisUtil.set(Constants.REDIS_USER_KEY + ":phone" + phone, user, 300);
        }
        return user;
    }

    //校验手机号
    public boolean checkPhone(String phone) {

        return partnerMapper.checkPhone(phone);
    }

    public boolean checkWXID(String wxid) {
        return partnerMapper.checkWXID(wxid);
    }


    public boolean updateInvite(Long userId) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        return partnerMapper.updateInvite(userId) > 0;
    }


    public void updateVersion(Long version) {
        partnerMapper.updateVersion(version);
    }


    public PartnerVO selectPartnerInfo(Long userId) {
        PartnerDO partner = this.getPartnerById(userId);
        PartnerVO partnerVO = PartnerVO.builder().build();
        return partnerVO;
    }

    public boolean updatePassword(Long userId, String pwd) {
        redisUtil.del(Constants.REDIS_USER_KEY + ":userId" + userId);
        return this.partnerMapper.updatePayPassword(userId, null, pwd) > 0;

    }

    public boolean requestCashOut(Long userId, BigDecimal amount, String cardNo, String cardRealName, String openingBank) {

        return userAssetService.requestCashOut(userId, amount, cardNo, cardRealName, openingBank);
    }

    public List<UserIncomeListVO> selectIncomeList(Long userId, Integer index, Integer size) {
        int startIndex = (index - 1) * size;
        return null;
    }
}
