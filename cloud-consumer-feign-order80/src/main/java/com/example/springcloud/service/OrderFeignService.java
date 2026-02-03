package com.example.springcloud.service;

import org.example.springcloud.pojo.entity.Payment;
import org.example.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description Feign接口
 * @Author fsy
 * @Date 2023/7/4 14:38
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") // 客户端默认等待 1 秒钟
public interface OrderFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id); // 在feign中 @PathVariable("id") 不能自动绑定

    /**
     * 测试请求超时
     * @return 被调服务端口
     */
    @GetMapping("/payment/timeout")
    String paymentFeignTimeOut();
}


