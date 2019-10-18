package com.example.shriodemo.service;


import com.example.shriodemo.bean.UserInfo;

import org.springframework.stereotype.Service;
/*
 * @Author liuxin
 * @Description //TODO
 **/
@Service
public interface UserService {

    UserInfo save(UserInfo userInfo);

    UserInfo findByUserName(String username);

   public  void   userTest();

}
