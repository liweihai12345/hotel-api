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
 * @Date: Created in 2019/4/3 9:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTeamControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    @Before
    public void before(){
        mvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void bindTeam() throws Exception {
        //uid 29705
        String url= "/api/team/bind-team";
        ResultActions result = mvc.perform(post(url).param("token", "821bf47f57426164b5b6f71f973dea5a")
                .param("phone", "13269050112").param("useid","29707"))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }
}