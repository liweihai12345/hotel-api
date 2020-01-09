package com.platform.service;


import com.alibaba.fastjson.JSON;
import com.platform.mapper.ApiSysConfigMapper;
import com.platform.exception.RRException;
import com.platform.vo.SysConfigVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SysConfigService {
    @Autowired
    private ApiSysConfigMapper sysConfigMapper;



    public List<SysConfigVO> queryList(Map<String, Object> map) {
        return sysConfigMapper.queryList(map);
    }


}
