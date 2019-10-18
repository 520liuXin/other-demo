package com.example.shriodemo.controller;

/*
 * @Author liuxin
 * @Description //TODO
 **/


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping(name = "/hello")
    public String helloWord(){
        System.out.println("hello,world");
        return "hello,world";
    }
}
