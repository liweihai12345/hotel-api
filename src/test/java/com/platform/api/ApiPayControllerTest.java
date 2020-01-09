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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/4/16 11:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiPayControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    @Before
    public void before(){
        mvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void order() throws Exception {
        //uid 29705
        String url= "/api/make/pay";
        ResultActions result = mvc.perform(post(url).param("token", "05a2752f8b73e5fb562e24e4303a650e")
                .param("pid", "69").param("pay_way","1").param("aid","311")
                .param("remark","测试").param("num","1"))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }
}