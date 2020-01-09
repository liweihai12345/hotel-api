package com.platform.service;

import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.entity.SmsTemplateDO;
import com.platform.mapper.SmsTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-21 00:36:13
 */
@Service("smsTemplateService")
public class SmsTemplateService {
    @Autowired
    private SmsTemplateMapper smsTemplateMapper;
    @Autowired
    private RedisUtil redisUtil;

    public SmsTemplateDO queryObject(Integer id) {

        return smsTemplateMapper.queryObject(id);
    }

    public List<SmsTemplateDO> queryList(Map<String, Object> map) {
        return smsTemplateMapper.queryList(map);
    }


    public SmsTemplateDO selectTemplate(Integer tid) {
        List<SmsTemplateDO> list = (List<SmsTemplateDO>) redisUtil.get(Constants.REDIS_SMS_TEMPLATE_KEY);
        if (list == null || list.size() == 0) {
            list = this.queryList(null);
            redisUtil.set(Constants.REDIS_SMS_TEMPLATE_KEY, list);
        }
        Optional<SmsTemplateDO> temp = list.stream().filter(sms -> sms.getTemplateid() == tid).findFirst();
        if (temp.isPresent()) {
            return temp.get();
        }
        return null;
    }
}
