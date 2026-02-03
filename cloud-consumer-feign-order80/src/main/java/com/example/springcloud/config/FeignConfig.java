package com.example.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 配置类
 * @Author fsy
 * @Date 2023/7/4 16:38
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {

        return Logger.Level.FULL;
    }
}
