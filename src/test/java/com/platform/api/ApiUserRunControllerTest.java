package com.platform.api;

import com.platform.common.Constants;
import com.platform.config.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/1/29 15:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApiUserRunControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private RedisUtil redisUtil;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void today() throws Exception {
//        String url = "/api/run/today";
//        ResultActions result = mvc.perform(post(url).param("token", "d7e712962802e7227997f9f2810ca1e9").param("type", "1"))
//                .andExpect(status().isOk())
//                .andDo(print());
//        System.out.println(result);
//        boolean value = redisUtil.hasKey(Constants.REDIS_RANK_KEY);
//        System.out.println(value);
//        redisUtil.set(Constants.REDIS_RANK_KEY, "@Scheduled rank()", 100);


    }

    @Test
    public void  dataV3() throws Exception{
        String url= "/api/v3/data";
        ResultActions result = mvc.perform(post(url).param("token", "da1add560271810e2ca96dcebb04aba4"));
        System.out.println(result);
    }
    @Test
    public void  dataV31() throws Exception{
        String url= "/api/v3/data";

        long time = redisUtil.getExpire("54776afcd905d1cd51bce9a883903ba9", TimeUnit.DAYS);
        System.out.println(time);
    }
}