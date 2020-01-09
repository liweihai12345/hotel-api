package com.platform.mapper;

import com.platform.entity.PartnerDO;
import com.platform.vo.UserRegVO;
import com.platform.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 合伙人信息dao
 *
 * @author wolf
 * @Date 2018年12月3日 上午11:07:06
 */
public interface PartnerMapper {


    int addPartner(PartnerDO partner);


    PartnerDO getPartnerById(@Param("id") Long id);

    PartnerDO getPartnerByMobile(@Param("mobile") String mobile);

    List<PartnerDO> queryList(@Param("list") List<String> list);

    int updateDone(@Param("userId") Long userId);

    /**
     * 绑定微信信息
     *
     * @param id
     * @param openid
     * @return
     */
    public int bindwx(@Param("id") Long id, @Param("openid") String openid);


    /**
     * 完善个人信息
     *
     * @param id
     * @param name
     * @param gender
     * @param birthDate
     * @param address
     * @param signature
     */
    int updateParterInfo(@Param("id") Long id, @Param("name") String name, @Param("gender") Integer gender,
                         @Param("birthDate") String birthDate, @Param("address") String address, @Param("signature") String signature);

    int updateDeviceToken(@Param("userId") Long userId, @Param("deviceToken") String deviceToken, @Param("deviceType") Integer deviceType);

    /**
     * 更换手机号
     *
     * @param uid
     * @param mobile
     */
    int updateMobile(@Param("uid") Long uid, @Param("mobile") String mobile, @Param("oldMobile") String oldMobile);


    /**
     * 修改支付密码
     */
    int updatePayPassword(@Param("userId") Long userId, @Param("old") String old, @Param("pwd") String pwd);


    /**
     * 更新合伙人头像
     *
     * @param id         合伙人编号
     * @param pictureUrl 头像地址
     */
    int updatePictureUrl(@Param("id") Long id, @Param("pictureUrl") String pictureUrl);


    Integer queryRegCountForDate(@Param("start") String start, @Param("end") String end, @Param("isDone") Integer isDone);

    Integer queryTotalCountForDate(@Param("isDone") Integer isDone);

    List<UserRegVO> selectLatestReg();

    boolean checkPhone(@Param("phone") String phone);


    int updateInvite(@Param("userId") Long userId);

    int updateUsername(@Param("userId") Long userId, @Param("realName") String realName);


    /**
     * 修改用户背景图片
     *
     * @param param
     * @return
     */
    int updateUserBgImg(Map<String, Object> param);

    /**
     * 查询用户详细信息 otc
     *
     * @param phone
     * @return
     */
    Map<String, Object> queryUserDetailsByPhone(@Param("phone") String phone);

    boolean checkWXID(@Param("unionId") String unionId);

    PartnerDO getPartnerByWX(@Param("unionId") String unionId);

    int unBindWX(@Param("id") Long id);


    List<UserVO> selectUserList(@Param("nickName") String nickName, @Param("start") int start, @Param("size") Integer size);


    List<PartnerDO> selectUserListForId(@Param("list") List<Long> list);

    int updateVersion(@Param("userid") Long userid);

    List<PartnerDO> selectUserForLevel(@Param("level") Integer level);

    void updateUserLevel(@Param("list") List<Long> list, @Param("level") Integer level);
}
