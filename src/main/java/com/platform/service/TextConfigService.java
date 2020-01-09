package com.platform.service;

import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.entity.TextConfigDO;
import com.platform.mapper.TextConfigMapper;
import com.platform.vo.TextConfigVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author liweihai
 * @email liweihai12345@sina.com
 * @date 2019-03-18 14:17:08
 */
@Service("textConfigService")
public class TextConfigService {
    @Autowired
    private TextConfigMapper textConfigMapper;
    @Autowired
    private RedisUtil redisUtil;


    public TextConfigDO queryObject(Integer id) {
        return textConfigMapper.queryObject(id);
    }


    public List<TextConfigDO> queryList() {
        List<TextConfigDO> list = (List<TextConfigDO>) redisUtil.get(Constants.REDIS_TEXT_CONF);
        if(list==null){
            list =textConfigMapper.queryList();
            redisUtil.set(Constants.REDIS_TEXT_CONF,list);
        }
        return list;
    }


    public int queryTotal(Map<String, Object> map) {
        return textConfigMapper.queryTotal(map);
    }

    public TextConfigVO selectTextForType(Integer type) {
        TextConfigVO tf = TextConfigVO.builder().build();
        List<TextConfigDO> list = this.queryList();
        TextConfigDO text =list.stream().filter(o->type.equals(o.getType())).findFirst().orElse(new TextConfigDO());
        BeanUtils.copyProperties(text,tf);
        return tf;
    }
}
