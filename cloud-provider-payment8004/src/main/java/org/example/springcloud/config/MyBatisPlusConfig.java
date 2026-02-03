package org.example.springcloud.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/3/3 12:55
 */
@Configuration
@MapperScan("org.example.**.dao")
public class MyBatisPlusConfig {

        @Bean
        public PaginationInterceptor paginationInterceptor(){
            return new PaginationInterceptor();
        }
}
