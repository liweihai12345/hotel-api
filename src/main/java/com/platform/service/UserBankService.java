package com.platform.service;

import com.platform.entity.PartnerDO;
import com.platform.entity.UserBankDO;
import com.platform.mapper.UserBankMapper;
import com.platform.vo.UserBankVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/13 14:42
 */
@Service
public class UserBankService {
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private UserBankMapper userBankMapper;
    @Autowired
    private UserAssetService userAssetService;

    public boolean insert(UserBankDO bank) {

        return userBankMapper.save(bank) > 0;
    }

    public UserBankVO selectUserBank(Long userId) {
        UserBankDO bank = this.queryObject(userId);
        UserBankVO bv = UserBankVO.builder().build();
        if(!StringUtils.isEmpty(bank)){
            BeanUtils.copyProperties(bank, bv);
        }
        return bv;
    }

    public UserBankDO queryObject(Long userId) {

        return userBankMapper.queryObject(userId);
    }

    public List<UserBankVO> queryList(Long userId) {

        return userBankMapper.selectList(userId);
    }

    @Transactional
    public boolean addUserBack(Long userId, String cardNo, String cardBank, String openBank, String realName, String idCardNo, String reservePhone) {

        userAssetService.updateUserAsset(userId,realName);
        PartnerDO user = partnerService.getPartnerById(userId);
        partnerService.updateUsername(userId,user.getRealName());
        UserBankDO ub = UserBankDO.builder().cardNo(cardNo).uid(userId).phone(user.getMobile()).cardBank(cardBank)
                .openBank(openBank).idCardNo(idCardNo).realName(realName).reservePhone(reservePhone).build();
        return this.insert(ub);
    }
}
