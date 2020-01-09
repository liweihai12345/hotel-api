package com.platform.service;

import com.platform.mapper.FilePathMapper;
import com.platform.vo.FilePathVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class FilePathService {
    @Autowired
    private FilePathMapper pathMapper;


    public FilePathVO queryObject(Integer type) {
        List<FilePathVO> list = pathMapper.selectOssConfig(type);
        return list.get(0);
    }

    public List<FilePathVO> queryList(Map<String, Object> map) {
        return pathMapper.selectOssConfig(1);
    }

}
