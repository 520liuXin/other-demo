package com.example.shriodemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/*
 * @Author liuxin
 * @Description //TODO 將post中請求參數json轉換成對象
 **/
@Configuration
@Component
public class AppWebConfiguration implements WebMvcConfigurer {

    /**
     * 重写添加拦截器方法并添加配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> messageConverter : converters) {
            System.out.println(messageConverter);
        }
    }

}
