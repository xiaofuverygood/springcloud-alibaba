package org.example.myrule;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.context.annotation.Bean;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 配置类
 * @Author fsy
 * @Date 2023/6/30 16:48Ø
 */
@Configuration
public class MySelfRule {

    // 定义随机
    @Bean
    public IRule getRule() {
        return new RandomRule();
    }
}
