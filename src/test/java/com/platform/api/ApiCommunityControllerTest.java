package com.platform.api;

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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/6/20 15:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiCommunityControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void videoList() throws Exception {
        String url = "/api/community/video-list";
        ResultActions result = mvc.perform(get(url).param("token", "0515d490197783c898662658ba4488fe").param("index", "1")
                .param("size", "5").param("type", "3")
                .param("uid", "").param("dynamicId", "594221")).andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }
}