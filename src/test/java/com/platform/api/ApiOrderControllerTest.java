package com.platform.api;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.platform.dto.OrderProParamDTO;
import com.platform.entity.OrderDetailDO;
import com.platform.mapper.OrderDetailMapper;
import com.platform.mapper.OrderMapper;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/4/25 18:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiOrderControllerTest {
    private MockMvc mvc;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void drawback() throws Exception {
        //uid 29705
        String url = "/api/order/drawback";
        ResultActions result = mvc.perform(post(url).param("token", "38be278886d6a54df74cf6c73251d21f")
                .param("orderNo", "20190425180227115").param("proStatu", "1").param("statuName", "产品状态文字描述")
                .param("cause", "退款原因").param("explain", "退款说明").param("certificate", "凭证"))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }

    @Test
    public void insertAll() throws Exception {
        List<OrderDetailDO> des = Lists.newArrayList();
//        List<OrderDO> list= orderMapper.selectOrderALLList();
//        for (OrderDO o:list){
//            OrderDetailDO detail = OrderDetailDO.builder().orderNo(o.getOrderNo()).proId(o.getProductId()).proName(o.getProductName()).proUrl(o.getProductUrl())
//                    .num(o.getNumber()).styleId(1).styleName("产品款式").styleUrl(o.getProductUrl()).description(o.getRemark()).price(o.getAmount()).build();
//            des.add(detail);
//        }
//        orderDetailMapper.insertAll(des);
    }

    @Test
    public void shopSubmit() throws Exception {
        List<OrderDetailDO> des = Lists.newArrayList();
        Integer aid = 1124;
        Integer pay_way = 1;
        List<OrderProParamDTO> list = new ArrayList<>();
        OrderProParamDTO param = OrderProParamDTO.builder().remark("商家1").sids("169,170,171").build();
        list.add(param);
        String url = "/api/order/shop-submit";
        ResultActions result = mvc.perform(post(url).param("token", "57acedae3c9ee801501fdc1525107027")
                .param("aid", String.valueOf(aid)).param("pay_way", String.valueOf(pay_way)).param("list", JSON.toJSONString(list)))
                .andExpect(status().isOk()).andDo(print());
        System.out.println(result);
    }


}