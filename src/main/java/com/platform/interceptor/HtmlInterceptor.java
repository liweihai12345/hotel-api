package com.platform.interceptor;

import com.platform.annotation.AuthCheckSign;
import com.platform.annotation.IgnoreAuth;
import com.platform.exception.ApiRRException;
import com.platform.util.AccountValidatorUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HtmlInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        IgnoreAuth annotation;
        AuthCheckSign authCheckSign = null;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
            if (annotation != null) {
                return true;
            }
            authCheckSign = ((HandlerMethod) handler).getMethodAnnotation(AuthCheckSign.class);

            if (authCheckSign != null) {
                if (!AccountValidatorUtil.checkRequestHeader(request)) {
                    throw new ApiRRException("参数错误", 500);
                } else if (!AccountValidatorUtil.checkRequestSign(request, 1)) {
                    throw new ApiRRException("认证错误", 500);
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
        return true;
    }


}
