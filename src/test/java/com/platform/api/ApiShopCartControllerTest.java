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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/5/5 16:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiShopCartControllerTest {
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void add() throws Exception {
        String url = "/api/cart/add-shop";
        ResultActions result = mvc.perform(post(url).header("token", "57acedae3c9ee801501fdc1525107027")
//                .param("pid", "198").param("number", "1").param("styleId", "248"))
                .param("pid", "146").param("number", "1").param("styleId", "262"))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }

    @Test
    public void shop() throws Exception {
        String url = "/api/cart/my-shop";
        ResultActions result = mvc.perform(get(url).header("token", "57acedae3c9ee801501fdc1525107027")).andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }

    @Test
    public void count() throws Exception {
        String url = "/api/cart/count";
        ResultActions result = mvc.perform(get(url).header("token", "57acedae3c9ee801501fdc1525107027"))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }

    @Test
    public void modify() throws Exception {
        String url = "/api/cart/modify";
        ResultActions result = mvc.perform(post(url).header("token", "57acedae3c9ee801501fdc1525107027")
                .param("id", "5").param("number", "1"))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }

    @Test
    public void delete() throws Exception {
        String url = "/api/cart/delete";
        ResultActions result = mvc.perform(post(url).header("token", "57acedae3c9ee801501fdc1525107027")
                .param("ids", "2,3,4"))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }
}