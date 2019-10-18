package com.example.shriodemo.controller;



import com.alibaba.fastjson.JSON;
import com.example.shriodemo.bean.request.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/*
 * @Author liuxin
 * @Description //TODO
 **/


@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    private MockHttpSession session;


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        session = new MockHttpSession();
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }



    @Test
    public void addLearn() throws Exception{
        UserVo userVo=new UserVo();
        userVo.setUid(743824792L);
        userVo.setUsername("da564dad");
        userVo.setPassword("324645");
        String jsonString = JSON.toJSONString(userVo);
        log.info(jsonString);
        log.info("开始测试");
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders
                        .post("/user/add").content(jsonString)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(jsonString.getBytes()) //传json参数
        ).andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
        log.info(mvcResult.getResponse().toString());

        log.info("测试完成");
    }

    @Test
    public void userSaveTest() throws Exception{
        UserVo userVo=new UserVo();
        userVo.setUid(743824792L);
        userVo.setUsername("dadad");
        userVo.setPassword("324");
        String jsonString = JSON.toJSONString(userVo);
        log.info(jsonString);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/user/save")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString.getBytes()) //传json参数
        ).andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }










}
