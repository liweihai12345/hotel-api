package com.platform.interceptor;

import com.platform.api.ApiBaseAction;
import com.platform.exception.*;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Map;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/5/19 11:05
 */
@ControllerAdvice
public class BaseExceptionHandler extends ApiBaseAction {

    /**
     * 参数绑定异常
     */
    @ExceptionHandler({BindException.class, MissingServletRequestParameterException.class, TypeMismatchException.class,
            ApiRRException.class, SQLException.class, ApiInviteException.class, ApiOrderException.class, ApiAssetException.class})
    @ResponseBody
    public Map<String, Object> bindException(Exception e) {
        if (e instanceof BindException) {
            return toResponsObject(1, "参数绑定异常", e.getMessage());
        } else if (e instanceof ApiOrderException) {
            ApiOrderException apie = (ApiOrderException) e;
            return toResponsObject(apie.getErrno(), apie.getErrmsg(), e.getMessage());
        } else if (e instanceof ApiInviteException) {
            ApiInviteException apie = (ApiInviteException) e;
            return toResponsObject(apie.getErrno(), apie.getErrmsg(), e.getMessage());
        } else if (e instanceof ApiRRException) {
            ApiRRException apie = (ApiRRException) e;
            return toResponsObject(apie.getErrno(), apie.getErrmsg(), e.getMessage());
        } else if (e instanceof ApiAssetException) {
            ApiAssetException apie = (ApiAssetException) e;
            return toResponsObject(apie.getErrno(), apie.getErrmsg(), apie.getErrmsg());
        } else if (e instanceof ApiAuctionException) {
            ApiAuctionException apie = (ApiAuctionException) e;
            return toResponsObject(apie.getErrno(), apie.getErrmsg(), apie.getErrmsg());
        } else if (e instanceof SQLException) {
            return toResponsObject(501, "数据库异常", e.getMessage());
        }
        return toResponsObject(1, "处理异常", e.getMessage());
    }

    /**
     * initBinder 初始化绑定 <br>
     * 这里处理了3种类型<br>
     * 1、字符串自动 trim 去掉前后空格 <br>
     * 2、java.util.Date 转换为 "yyyy-MM-dd HH:mm:ss" 格式<br>
     * 3、java.sql.Date 转换为 "yyyy-MM-dd" 格式<br>
     * 4、java.util.Timestamps 时间转换
     *
     * @param binder  WebDataBinder 要注册的binder
     * @param request 前端请求
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        // 字符串自动Trim
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }

    /**
     * 视图统一处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = WebViewException.class)
    public ModelAndView myErrorHandler(WebViewException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errno", ex.getErrno());
        modelAndView.addObject("errmsg", ex.getMessage());
        return modelAndView;
    }
}
