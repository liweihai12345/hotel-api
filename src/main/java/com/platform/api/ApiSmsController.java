package com.platform.api;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.platform.annotation.ApiVersion;
import com.platform.annotation.AuthCheckSign;
import com.platform.config.RedisUtil;
import com.platform.entity.SmsTemplateDO;
import com.platform.payinterface.ali.yunpian.AliSmsUtil;
import com.platform.service.SmsTemplateService;
import com.platform.util.SmsUtil;
import com.platform.util.enums.ValidatePrefixEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Api(tags = "短信发送")
@RestController
@RequestMapping("/api/sms")
public class ApiSmsController extends ApiBaseAction {
    private static final Logger logger = LoggerFactory.getLogger(ApiSmsController.class);
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SmsTemplateService smsTemplateService;


    @AuthCheckSign
    @ApiVersion(2)
    @ApiOperation(value = "获取短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "access_token", value = "access_token", required = true),
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "timestamp", value = "timestamp", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "version", value = "v2", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "mobile", value = "手机号", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "INTEGER", name = "type", value = "1注册2登陆3找回4忘记5重置6修改7支付密码", required = true)})
    @PostMapping(value = "/{version}/send")
    public Object sendV2(@PathVariable("version") String version, @RequestParam(value = "mobile") String mobile, @RequestParam(value = "type") Integer type) {

        if (StringUtils.isEmpty(mobile)) {
            return toResponsFail("手机号不能为空");
        }
        // 生成随机验证码
        String randomCode = SmsUtil.getRandomCode();
        if (type == 1) {
            redisUtil.set(ValidatePrefixEnum.REG_PRE_PRE + mobile, randomCode, 600);
        } else if (type == 2) {
            redisUtil.set(ValidatePrefixEnum.BACK_PRE_PRE + mobile, randomCode, 600);
        } else if (type == 3) {
            redisUtil.set(ValidatePrefixEnum.FORGET_PRE_PRE + mobile, randomCode, 600);
        } else if (type == 4) {
            redisUtil.set(ValidatePrefixEnum.RESET_PRE_PRE + mobile, randomCode, 600);
        } else if (type == 5) {
            redisUtil.set(ValidatePrefixEnum.UPDATE_PRE_PRE + mobile, randomCode, 600);
        } else if (type == 6) {
            redisUtil.set(ValidatePrefixEnum.BIND_BANK_PRE + mobile, randomCode, 600);
        } else if (type == 7) {
            redisUtil.set(ValidatePrefixEnum.FORGET_PRE_PAY + mobile, randomCode, 300);
        } else {
            return toResponsFail("未知类型");
        }

        logger.info("send mobile = {},code :{}", mobile, randomCode);
        SmsTemplateDO temp = smsTemplateService.selectTemplate(9);
        // 发送短信
        SendSmsResponse re = AliSmsUtil.sendSms(mobile, temp, randomCode);
        if ("OK".equals(re.getCode())) {
            return toResponsSuccess(true);
        }
        return toResponsFail("发送失败");
    }
}
