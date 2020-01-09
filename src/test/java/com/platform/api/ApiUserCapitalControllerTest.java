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
 * @Date: Created in 2019/4/15 19:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiUserCapitalControllerTest {
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    @Before
    public void before(){
        mvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void transfer() throws Exception {
//amount=100&code=2031ee13aa4339660006f0fa4a3c6061&phone=15101046482&token=a4bf500a188a6947c32fc3442bd08ffb
        String url= "/api/capital/transfer";
        ResultActions result = mvc.perform(post(url).param("token", "a4bf500a188a6947c32fc3442bd08ffb")
                .param("phone", "15101046482").param("code","2031ee13aa4339660006f0fa4a3c6061")
                .param("amount","100"))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }
}