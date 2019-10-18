package com.example.shriodemo.service;


import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Service
public interface ThreadService {


    public void testPool();

    public void testNoPool();

    public int testPoolTaskExecutor(int n) throws InterruptedException, ExecutionException;

}
