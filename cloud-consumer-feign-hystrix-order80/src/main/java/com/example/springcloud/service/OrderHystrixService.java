package com.example.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/7/17 13:44
 */
@Component
// @FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = OrderHystrixFallbackService.class)
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/OK/{id}")
    String paymentInfo_OK(@PathVariable("id") int id);

    @GetMapping("/payment/hystrix/TimeOut/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") int id);
}
