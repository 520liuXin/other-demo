package com.example.shriodemo.service.impl;


import com.example.shriodemo.bean.UserInfo;
import com.example.shriodemo.dao.UserDao;
import com.example.shriodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Service
public class UserServicrImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserInfo save(UserInfo userInfo) {
        userInfo.setCreatedDate(LocalDate.now());
        userInfo.setUpdatedDate(LocalDateTime.now());
        UserInfo user =userDao.save(userInfo);
        return user;
    }

    @Override
    public UserInfo findByUserName(String username) {
        UserInfo user=userDao.findByUsername(username);


        return user;
    }
    @Override
    public void userTest(){
        System.out.print("1");
    }
}
