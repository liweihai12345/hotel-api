package com.platform.mapper;

import com.platform.vo.FilePathVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:46
 */
public interface FilePathMapper extends BaseDao<FilePathVO> {

    List<FilePathVO> selectOssConfig(@Param("type") Integer type);
}
