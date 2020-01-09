package com.platform.mapper;

import com.platform.dto.DynamicPraiseDTO;
import com.platform.entity.DynamicPraiseDO;
import com.platform.vo.PraiseVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:25
 */
public interface DynamicPraiseMapper {


   List<Long> selectPraiseDidList(@Param("list") List<Long> list , @Param("userId") Long userId);

    List<DynamicPraiseDTO> selectPraiseList(@Param("list") List<Long> list);

    List<Long> selectPraiseForUid(@Param("uid") Long uid);

    Integer praiseAddCount(@Param("userid")Long userid);

    boolean checkPriaise(Map<String,Object> map);

    int insert(DynamicPraiseDO p);

    int delete(Map<String,Object> map);

    List<PraiseVO> praiseListByUserId(Map<String,Object> map);

    int updatePraise(@Param("id")Long id);

    int readPraiseAll(@Param("userid")Long userid);

    int deleteDynamic(@Param("did")Long did);
}
