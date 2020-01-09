package com.platform.api;

import com.platform.annotation.IgnoreAuth;
import com.platform.config.RedisUtil;
import com.platform.service.InviteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邀请注册
 */
@Slf4j
@CrossOrigin(allowCredentials = "true", maxAge = 3600)
@Api(tags = "HTML邀请注册")
@RestController
@RequestMapping("/html/invite")
public class ApiInviteController extends ApiBaseAction {
    @Autowired
    private InviteService inviteService;
    @Autowired
    private RedisUtil redisUtil;


    @IgnoreAuth
    @ApiOperation(value = "我的邀请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "invite_mobile", dataType = "String", paramType = "query", value = "邀请人手机号", required = true),
            @ApiImplicitParam(name = "mobile", dataType = "String", paramType = "query", value = "被邀请人手机号", required = true),
    })
    @GetMapping(value = "/user-register")
    public Object modifyPass(String invite_mobile, String mobile) {
        boolean result = inviteService.saveInvite(invite_mobile, mobile);
        return toResponsSuccess(result);
    }

}
