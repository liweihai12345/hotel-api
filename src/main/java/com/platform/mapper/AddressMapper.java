package com.platform.mapper;

import com.platform.entity.AddressDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper extends BaseDao<AddressDO> {

    AddressDO queryAddress(@Param("userId") Long userId);

    AddressDO selectDetailAddress(@Param("userId") Long userId);

    int updateDefault(@Param("id") Integer id);

    int deleteDefault(@Param("userId") Long userId);

    List<AddressDO> selectAddressList(@Param("userId") Long userId, @Param("start") Integer start, @Param("size") Integer size);
}
