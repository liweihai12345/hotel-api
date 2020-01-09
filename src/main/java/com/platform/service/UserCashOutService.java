package com.platform.service;

import com.platform.entity.PartnerDO;
import com.platform.entity.UserAssetDO;
import com.platform.entity.UserBankDO;
import com.platform.entity.UserCashOutDO;
import com.platform.mapper.UserCashOutMapper;
import com.platform.util.BigDecimalUtil;
import com.platform.util.OrderNoUtils;
import com.platform.vo.UserCashOutVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/2/13 14:41
 */
@Service
public class UserCashOutService {
    @Autowired
    private UserCashOutMapper userCashOutMapper;
    @Autowired
    private UserAssetService userAssetService;

    public boolean insert(UserCashOutDO cash) {

        return userCashOutMapper.save(cash) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean addCashOut(UserBankDO bank, UserAssetDO asset, PartnerDO partner, BigDecimal amount) {
        asset.setFrozen(BigDecimalUtil.add(asset.getFrozen(),amount));
        boolean result = userAssetService.updateAccount(asset);
        if (result) {
            UserCashOutDO cash = UserCashOutDO.builder().uid(partner.getId()).phone(partner.getMobile()).cashNo(OrderNoUtils.getCashByUUID(String.valueOf(partner.getId())))
                    .cardNo(bank.getCardNo()).cardBank(bank.getCardBank()).idCardNo(bank.getIdCardNo()).openBank(bank.getOpenBank())
                    .realName(bank.getRealName()).reservePhone(bank.getReservePhone()).amount(amount).build();
            return this.insert(cash);
        }
        return result;
    }

    public UserCashOutDO queryObject(Long cashId) {
        return userCashOutMapper.queryObject(cashId);
    }

    public UserCashOutVO selectCashOut(Long cashId) {
        UserCashOutDO cash = this.queryObject(cashId);
        UserCashOutVO co = UserCashOutVO.builder().build();
        BeanUtils.copyProperties(cash, co);
        return co;
    }

    public List<UserCashOutVO> selectCashList(Long userId, Integer index, Integer size) {
        int start = (index - 1) * size;
        return userCashOutMapper.selectCashList(userId, start, size);
    }
}
