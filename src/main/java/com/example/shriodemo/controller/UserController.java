package com.example.shriodemo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.shriodemo.bean.Response;
import com.example.shriodemo.bean.UserInfo;
import com.example.shriodemo.bean.request.UserVo;
import com.example.shriodemo.service.UserService;
import com.example.shriodemo.utils.CheckUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public Response userAdd(@RequestBody UserVo userVo){

        UserInfo userInfo=userService.findByUserName(userVo.getUsername());
        if(CheckUtils.isNotEmpty(userInfo)){
            log.info("用户已存在，请勿重复注册");
            return Response.fail("用户已存在，请勿重复注册");
        }
//        UserInfo userVo = JSON.parseObject(params.toJSONString(), UserInfo.class);
//        UserInfo userInfo1=userService.save(userVo);
//        log.info(params.toJSONString());
        return Response.success();
    }


    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    public Response userSave(@RequestBody JSONObject params){

        log.info(params.toJSONString());
        return Response.success();
    }
    /**
     * 新添教程
     * @param
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public Response addLearn(){
        //learnService.save(learn);
        log.info("进入接口");
        return Response.fail();
    }



}
