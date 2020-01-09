package com.platform.util;

import com.platform.entity.PartnerDO;
import com.platform.vo.ProductVO;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/4/28 10:14
 */
public class OrderCheckUtil {

    public static Map check(PartnerDO user, ProductVO pro) {
        Map<String, String> map = new HashMap<>();
//        if (StringUtils.isEmpty(user) || user.getStatus() == 0) {
//            log.error("用户信息错误,用户不存在或不是Done");
//            map.put("msg", "用户信息错误");
//            map.put("code", "500");
//            return map;
//        }
        if (StringUtils.isEmpty(pro) || pro.getNumber() <= 0) {
            map.put("msg", "兑换产品信息错误或库存暂时不足");
            map.put("code", "500");
            return map;
        }
        if (pro.getType() == 4 && user.getIsDone() > 0) {
            map.put("msg", "不能重复购买Done产品");
            map.put("code", "500");
            return map;
        }
        return null;
    }
    // 重复购买done产品
    public static boolean checkRepeat(PartnerDO user, ProductVO pro) {
        if (pro.getType() == 4 && user.getIsDone() > 0) {
            return false;
        }
        return true;
    }
    // 是否是有效产品
    public static boolean checkProduct( ProductVO pro) {

        if (StringUtils.isEmpty(pro) || pro.getNumber() < 0) {
            return false;
        }
        return true;
    }
    //必须是done购买
    public static boolean checkDoneBuy(PartnerDO user, ProductVO pro) {
        if (user.getIsDone()==0 && pro.getType()==4) {
            return false;
        }
        return true;
    }
}
