package com.platform.interceptor;

import com.platform.annotation.AuthCheckSign;
import com.platform.annotation.IgnoreAuth;
import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.entity.TokenEntity;
import com.platform.exception.ApiRRException;
import com.platform.service.TokenService;
import com.platform.util.AccountValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:38
 */
@Slf4j
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        IgnoreAuth annotation;
        AuthCheckSign authCheckSign = null;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
            if (annotation != null) {
                return true;
            }
            authCheckSign = ((HandlerMethod) handler).getMethodAnnotation(AuthCheckSign.class);
            if (authCheckSign != null) {
                if (!AccountValidatorUtil.checkAppRequestHeader(request)) {
                    throw new ApiRRException("临时参数错误", 1002);
                } else if (!AccountValidatorUtil.checkRequestSign(request, 2)) {
                    throw new ApiRRException("accessToken错误", 1002);
                } else if (!AccountValidatorUtil.checkTimeOut(request,authCheckSign.timestamp())) {
                    throw new ApiRRException("认证超时", 1003);
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }


        //从header中获取token
        String token = request.getHeader(Constants.LOGIN_TOKEN_KEY);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(Constants.LOGIN_TOKEN_KEY);
        }
        //token为空
        if (StringUtils.isEmpty(token)) {
            throw new ApiRRException("请先登录", 1000);

        }
        TokenEntity entity = (TokenEntity) redisUtil.get(token);
        if (StringUtils.isEmpty(entity)) {
            throw new ApiRRException("请先登录", 1000);
        }

//        //查询token信息
//         TokenEntity tokenEntity = tokenService.queryByToken(token);
//        if ( entity.getExpireTime().getTime() < System.currentTimeMillis()) {
//            throw new ApiRRException("token失效，请重新登录", 1000);
//        }
//
//        //设置userId到request里，后续根据userId，获取用户信息
//        request.setAttribute(LOGIN_USER_KEY, tokenEntity.getUserId());

        return true;
    }

}
