package com.example.springcloud.controller;

import com.example.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/7/17 13:44
 */

@Slf4j
@RestController
@RequiredArgsConstructor
// @DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
@RequestMapping("/consumer")
public class OrderHystrixController {

    @Value("${server.port}")
    private String serverPort;

    private final OrderHystrixService orderHystrixService;

    @GetMapping("/hystrix/OK/{id}")
    public String paymentInfo_OK(@PathVariable int id) {

        return orderHystrixService.paymentInfo_OK(id) + "\t" + "ClientPort:" + serverPort;
    }

    @GetMapping("/hystrix/TimeOut/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") int id) {
        // int age = 10 / 0;
        return orderHystrixService.paymentInfo_TimeOut(id) + "\t" + "ClientPort:" + serverPort;
    }

    public String paymentInfo_TimeOutFallback(int id) {

        return "线程池:" + Thread.currentThread().getName() + "\t" + "系统繁忙请稍后再试!(paymentInfo_TimeOutFallback)" + "port:" + serverPort;
    }

    // Global FallbackMethod
    public String payment_Global_FallbackMethod() {

        return "Global Exception Handle 😭...";
    }
}