package com.platform.api;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.platform.annotation.AuthCheckSign;
import com.platform.annotation.IgnoreAuth;
import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.entity.PartnerDO;
import com.platform.entity.TokenEntity;
import com.platform.payinterface.ali.sign.RSA;
import com.platform.payinterface.wx.WXUtil;
import com.platform.payinterface.wx.model.WXToken;
import com.platform.payinterface.wx.model.WXUserInfo;
import com.platform.service.PartnerService;
import com.platform.service.UserService;
import com.platform.util.AccountValidatorUtil;
import com.platform.util.enums.ValidatePrefixEnum;
import com.platform.vo.AdditionModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Api(tags = "用户登录")
@RestController
@RequestMapping("/api/login")
public class ApiLoginController extends ApiBaseAction {

    @Autowired
    private PartnerService partnerService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserService userService;


    @ApiOperation("退出登录")
    @PostMapping(value = "/loginout")
    public Object codeLogin(@RequestParam(value = "token", required = false) String token) {

        redisUtil.del(token);
        Map<String, Object> map = new HashMap<>();
        map.put("data", true);
        return toResponsSuccess(map);

    }

    @ApiOperation("登录token")
    @PostMapping(value = "/token")
    public Object token(@RequestParam(value = "token", required = false) String token) {
        long time = redisUtil.getExpire(token, TimeUnit.DAYS);
        Map<String, Object> map = new HashMap<>();
        if (time >= 1) {
            map.put("data", true);
            return toResponsSuccess(map);
        } else {
            TokenEntity entity = (TokenEntity) redisUtil.get(token);
            redisUtil.setLogin(token, entity, 3);
            map.put("data", true);
            return toResponsSuccess(map);
        }

    }


    /**
     * 手机号码登录
     *
     * @param mobile 手机号码
     * @param password   验证码
     */
    @AuthCheckSign
    @ApiOperation(value = "手机号登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "mobile", value = "手机号 ", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码 ", required = true)})
    @PostMapping(value = "/login")
    public Object login(@RequestParam(value = "mobile") String mobile, @RequestParam(value = "password") String password ) {

//        return regAndLogin(mobile, code, deviceToken);
        return toResponsSuccess(null);
    }

    private Object regAndLogin(String mobile, String code, String deviceToken) {
        String admin = String.valueOf(redisUtil.get("admin13888888888"));
        if (StringUtils.isEmpty(admin) || !"13888888888".equals(mobile)) {
            // 验证验证码
            String validate = (String) redisUtil.get(ValidatePrefixEnum.REG_PRE_PRE + mobile);
            if (StringUtils.isEmpty(code) || !code.equals(validate)) {
                return toResponsFail("验证码错误");
            }
        }
        // 手机号登录
        PartnerDO partner = partnerService.getPartnerByMobile(mobile);
        if (partner == null) {

        } else {
            if (!StringUtils.isEmpty(deviceToken) && !deviceToken.equals(partner.getDeviceTokens())) {
                partnerService.updateDeviceToken(partner.getId(), deviceToken);
                partner.setDeviceTokens(deviceToken);
                int deviceType = deviceToken.length() > 50 ? 2 : 1;
                partner.setDeviceType(deviceType);
            }
        }
        if (partner.getStatus() == 0) {
            return toResponsFail("账号已冻结，联系客服。");
        }
        if (!partner.isInvite()) {
            partnerService.addInviteCoin(partner);
        }
        // 正确后，删除验证码
        redisUtil.del(ValidatePrefixEnum.REG_PRE_PRE + mobile);
        AdditionModel model = userService.getUserLoginInfo(partner, null);
        return toResponsSuccess(model);
    }

    @IgnoreAuth
    @ApiOperation(value = "微信登陆")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "code", value = "code ", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "deviceToken", value = "deviceToken ", required = false)})
    @PostMapping("/wxLogin")
    public Object doWxLogin(@RequestParam(value = "code") String code, @RequestParam(value = "deviceToken", required = false) String deviceToken) {
        if (StringUtils.isEmpty(code)) {
            return toResponsFail("值不能为空。");
        }
        String result = WXUtil.getWxLoginToken(code);
        if (StringUtils.isEmpty(result)) {
            return toResponsFail("请重新使用微信登陆！");
        }
        JSONObject json = JSONObject.parseObject(result);
        WXToken token = JSONObject.toJavaObject(json, WXToken.class);
        if (StringUtils.isEmpty(token.getOpenid())) {
            return toResponsFail("请重新使用微信登陆！");
        }
        boolean flag = partnerService.checkWXID(token.getOpenid());
        if (!flag) {
            redisUtil.set(token.getOpenid(), token, 180);
            Map<String, Object> map = new HashMap<>();
            map.put("openid", token.getOpenid());
            return toResponsSuccess(map);
        }
        PartnerDO partner = partnerService.getPartnerByWX(token.getOpenid());
        if (partner.getStatus() == 0) {
            return toResponsFail("账号已冻结，联系客服。");
        }
        if (!StringUtils.isEmpty(deviceToken) && !deviceToken.equals(partner.getDeviceTokens())) {
            partnerService.updateDeviceToken(partner.getId(), deviceToken);
            partner.setDeviceTokens(deviceToken);
            int deviceType = deviceToken.length() > 50 ? 2 : 1;
            partner.setDeviceType(deviceType);
        }
        if (!partner.isInvite()) {
            partnerService.addInviteCoin(partner);
        }
        AdditionModel model = userService.getUserLoginInfo(partner, null);
        return toResponsSuccess(model);

    }

    @IgnoreAuth
    @ApiOperation(value = "微信绑定")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "mobile", value = "mobile ", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "code", value = "code ", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "openid", value = "openid ", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "deviceToken", value = "deviceToken ", required = false)})
    @PostMapping("/wx-bind")
    public Object doWxBind(@RequestParam(value = "openid") String openid, @RequestParam(value = "mobile") String mobile, @RequestParam(value = "code") String code,
                           @RequestParam(value = "deviceToken", required = false) String deviceToken) {
        if (StringUtils.isEmpty(mobile)) {
            return toResponsFail("手机号不能为空。");
        }


        String admin = String.valueOf(redisUtil.get("admin13888888888"));
        if (StringUtils.isEmpty(admin) || !"13888888888".equals(mobile)) {
            // 验证验证码
            String validate = (String) redisUtil.get(ValidatePrefixEnum.REG_PRE_PRE + mobile);

            if (StringUtils.isEmpty(code) || !code.equals(validate)) {
                return toResponsFail("验证码错误");
            }
        }
        if (StringUtils.isEmpty(openid)) {
            return toResponsFail("微信ID不能为空。");
        }
        WXToken token = (WXToken) redisUtil.get(openid);
        if (StringUtils.isEmpty(token)) {
            return toResponsFail("请重新使用微信登陆。");
        }
        String result = WXUtil.getWxUserInfo(token.getAccess_token(), token.getOpenid());
        if (StringUtils.isEmpty(result)) {
            return toResponsFail("请重新使用微信登陆！");
        }
        result = AccountValidatorUtil.replaceEmoji(result);
        JSONObject json = JSONObject.parseObject(result);
        WXUserInfo info = JSONObject.toJavaObject(json, WXUserInfo.class);
        PartnerDO p = partnerService.getPartnerByMobile(mobile);
        if (!StringUtils.isEmpty(p)) {
            if (!StringUtils.isEmpty(p.getWxUnionId())) {
                return toResponsFail("该手机号已绑定微信");
            }
            if (!p.isInvite()) {
                partnerService.addInviteCoin(p);
            }
            partnerService.bindWX(p.getId(), info.getOpenid());
            AdditionModel model = userService.getUserLoginInfo(p, null);
            return toResponsSuccess(model);
        } else {

            AdditionModel model = userService.getUserLoginInfo(p, null);
            // 正确后，删除验证码
            redisUtil.del(ValidatePrefixEnum.REG_PRE_PRE + mobile);
            return toResponsSuccess(model);
        }

    }

    @IgnoreAuth
    @ApiOperation("请求临时AccessToken")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "type", value = "1.活动h5token2.APP登陆短信token", defaultValue = "2", required = true)})
    @GetMapping(value = "/access-token")
    public Object temporary(@RequestParam(value = "type") Integer type) {
        //从header中获取token
        String token = request.getHeader(Constants.LOGIN_TOKEN_KEY);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(Constants.LOGIN_TOKEN_KEY);
        }
        TokenEntity entity = (TokenEntity) redisUtil.get(token);
        Long userId = null;
        if (entity != null) {
            userId = entity.getUserId();
        }
        Map<String, Object> map = Maps.newHashMap();
        long timestamp = System.currentTimeMillis();
        String content = Constants.getAccessToken(type) + String.valueOf(timestamp) + String.valueOf(userId);
        String accessToken = "";
        try {
            accessToken = RSA.getRsaSign(content, Constants.PRIVATE_KEY, "UTF-8");
        } catch (Exception e) {
            return toResponsFail("生成token失败");
        }
        map.put("timestamp", timestamp);
        map.put("access_token", accessToken);
        return toResponsSuccess(map);


    }

}
