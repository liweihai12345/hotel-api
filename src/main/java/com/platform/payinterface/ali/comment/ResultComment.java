package com.platform.payinterface.ali.comment;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/5/27 20:03
 */
@Slf4j
public class ResultComment {


    public static boolean result(JSONObject scrResponse) {
        if (200 == scrResponse.getInteger("code")) {
            JSONArray taskResults = scrResponse.getJSONArray("data");
            for (Object taskResult : taskResults) {
                if (200 == ((JSONObject) taskResult).getInteger("code")) {
                    JSONArray sceneResults = ((JSONObject) taskResult).getJSONArray("results");
                    //log.info(sceneResults.toJSONString());
                    return checkResult(sceneResults);
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean checkResult(JSONArray sceneResults) {
        for (Object sceneResult : sceneResults) {
            String scene = ((JSONObject) sceneResult).getString("scene");
            String label = ((JSONObject) sceneResult).getString("label");
            String suggestion = ((JSONObject) sceneResult).getString("suggestion");
            //根据scene和suggetion做相关的处理
            //do something
            if (!"normal".equalsIgnoreCase(label)) {
                return false;
            }
        }
        return true;
    }

}


