package com.platform.api;

import com.alibaba.fastjson.JSONObject;
import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import com.platform.entity.TokenEntity;
import com.platform.exception.ApiAssetException;
import com.platform.exception.ApiInviteException;
import com.platform.exception.ApiOrderException;
import com.platform.exception.ApiRRException;
import com.platform.service.TokenService;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author harmon
 * @ClassName: ApiBaseAction
 * @Description: 基础控制类
 * @date 2016年9月2日
 */
public class ApiBaseAction {
    /**
     * 得到request对象
     */
    @Autowired
    protected HttpServletRequest request;
    /**
     * 得到response对象
     */
    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected TokenService tokenService;
    @Autowired
    private RedisUtil redisUtil;


    /**
     * @param requestCode
     * @param msg
     * @param data
     * @return Map<String,Object>
     * @throws
     * @Description:构建统一格式返回对象
     * @date 2016年9月2日
     * @author zhuliyun
     */
    public Map<String, Object> toResponsObject(int requestCode, String msg, Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", requestCode);
        obj.put("msg", msg);
        if (data != null)
            obj.put("model", data);
        return obj;
    }

    public Map<String, Object> toResponsSuccess(Object data) {
        Map<String, Object> rp = toResponsObject(0, "执行成功", data);
        return rp;
    }

    public Map<String, Object> toResponsMsgSuccess(String msg) {
        return toResponsObject(0, msg, "");
    }

    public Map<String, Object> toResponsSuccessForSelect(Object data) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("list", data);
        return toResponsObject(0, "执行成功", result);
    }

    public Map<String, Object> toResponsFail(String msg) {
        return toResponsObject(1, msg, null);
    }



    /**
     * 获取请求方IP
     *
     * @return 客户端Ip
     */
    public String getClientIp() {
        String xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            return "8.8.8.8";
        }
        return xff;
    }

    public JSONObject getJsonRequest() {
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取请求的用户Id
     *
     * @return 客户端Ip
     */
    public Long getUserId() {
        //从header中获取token
        String token = request.getHeader(Constants.LOGIN_TOKEN_KEY);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(Constants.LOGIN_TOKEN_KEY);
        }
        //查询token信息
        //TokenEntity tokenEntity = tokenService.queryByToken(token);
        TokenEntity tokenEntity = (TokenEntity) redisUtil.get(token);
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new ApiRRException("请先登录", 1000);
        }
        return tokenEntity.getUserId();
    }
}
