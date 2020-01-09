package com.platform.api;

import com.platform.util.MD5Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/5/21 11:37
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiRecommendControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void focus() throws Exception {
        String loginToken = MD5Util.MD5Encode("13521147210" + "37063", "utf-8");

        String url = "/api/recommend/user-focus";
        ResultActions result = mvc.perform(get(url).param("userId", "219").param("token",loginToken)
                .param("index", "1").param("size", "8")).andExpect(status().isOk()).andDo(print());
        System.out.println(result);

    }
}