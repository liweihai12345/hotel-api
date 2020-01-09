package com.platform.service;

import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.entity.IncomeCoinConfigDO;
import com.platform.mapper.IncomeCoinConfigMapper;
import com.platform.util.enums.CoinConfigEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeCoinConfigService {
    @Autowired
    private IncomeCoinConfigMapper incomeCoinConfigMapper;
    @Autowired
    private RedisUtil redisUtil;


    /**
     * 查询spc奖励配置
     *
     * @param type 类型1注册2普通兑换3购买反链4done兑换5新用户注册6done邀请,7任务奖励8兑换产品10D-one产品
     * @return 配置
     */
    public IncomeCoinConfigDO selectCoinConfig(Integer type) {
        IncomeCoinConfigDO conf = (IncomeCoinConfigDO) redisUtil.get(Constants.REDIS_COIN_CONFIG_KEY + ":type" + type);
        if (StringUtils.isEmpty(conf)) {
            conf = incomeCoinConfigMapper.selectCoinConfig(type);
            redisUtil.set(Constants.REDIS_COIN_CONFIG_KEY + ":type" + type, conf);
        }
        return conf;
    }

    /**
     * 查询释放率
     * @param count
     * @return
     */
    public BigDecimal selectRateLeave(int count) {
        List<Integer> keys = new ArrayList<>();
        keys.add(CoinConfigEnum.CONFIG_TYPE_RELEASE_ONE.getKey());
        keys.add(CoinConfigEnum.CONFIG_TYPE_RELEASE_FIVE.getKey());
        keys.add(CoinConfigEnum.CONFIG_TYPE_POWER_FIFTY.getKey());


        List<IncomeCoinConfigDO> list = incomeCoinConfigMapper.selectConfigList();
        List<IncomeCoinConfigDO> newList = list.stream().filter(o -> keys.contains(o.getType())).sorted(Comparator.comparing(IncomeCoinConfigDO::getMinNum).reversed()).collect(Collectors.toList());
        for (IncomeCoinConfigDO conf:newList){
            if(BigDecimal.valueOf(count).compareTo( conf.getMinNum())>0){
                return conf.getValue();
            }
        }
        return BigDecimal.valueOf(0.001);
    }

    /**
     * 查询D-one数量跟级别
     * @param count
     * @return
     */
    public IncomeCoinConfigDO selectDoneNumLeave(int count) {
        List<Integer> keys = new ArrayList<>();
        keys.add(CoinConfigEnum.CONFIG_TYPE_RECOMMEND_ONE.getKey());
        keys.add(CoinConfigEnum.CONFIG_TYPE_RECOMMEND_THREE.getKey());
        List<IncomeCoinConfigDO> list = incomeCoinConfigMapper.selectConfigList();
        List<IncomeCoinConfigDO> newList = list.stream().filter(o ->keys.contains(o.getType())).sorted(Comparator.comparing(IncomeCoinConfigDO::getMinNum).reversed()).collect(Collectors.toList());
        for (IncomeCoinConfigDO conf:newList){
            if(BigDecimal.valueOf(count).compareTo( conf.getMinNum())>0){
                return conf;
            }
        }
        return null;
    }
}