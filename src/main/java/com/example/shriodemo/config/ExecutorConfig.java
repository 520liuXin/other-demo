package com.example.shriodemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


import java.util.concurrent.ThreadPoolExecutor;
/*
 * @Author liuxin
 * @Description //TODO 线程池的各种配置类
 **/
@Configuration
@EnableAsync
@Slf4j
public class ExecutorConfig {

    @Bean
    public ThreadPoolTaskExecutor defaultThreadPool() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数量
        threadPoolTaskExecutor.setCorePoolSize(2);
        //最大线程数量
        threadPoolTaskExecutor.setMaxPoolSize(5);
        //队列中最大任务数
        threadPoolTaskExecutor.setQueueCapacity(2);
        //线程名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("ThreadPool-");
        //当达到最大线程数时如何处理新任务
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程空闲后最大存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(60);
        //初始化线程池
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}