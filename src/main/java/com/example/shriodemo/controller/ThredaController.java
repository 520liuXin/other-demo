package com.example.shriodemo.controller;

import com.example.shriodemo.service.ThreadService;
import com.example.shriodemo.service.UserService;
import com.example.shriodemo.service.impl.ThredaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/*
 * @Author liuxin
 * @Description //TODO
 **/

@RestController
@Slf4j
public class ThredaController {
    @Autowired
    private ThreadService threadService;

    @Autowired
    private UserService userService;


    @RequestMapping("/pool")
    public String pool(){
        Long starTime=System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            userService.userTest();
        }
        Long endTime=System.currentTimeMillis();
        System.out.println("未使用线程时间:"+(endTime-starTime));

        log.info(""+endTime);
        Long starData=System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            threadService.testPool();
        }
        Long endData=System.currentTimeMillis();
        System.out.println("使用线程时间:"+(endData-starData));
        return "pool test";
    }


    @RequestMapping("/poolTask/{n}")
    public String poolTask(@PathVariable int n){
        long startTime = System.currentTimeMillis();
        try {
            threadService.testPoolTaskExecutor(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        return "poolTask test "+(endTime-startTime)/1000+" 秒";
    }
}
