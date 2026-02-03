package org.example.springcloud.controller;

import cn.hutool.core.comparator.ComparableComparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/7/10 14:36Ø
 */
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/OK/{id}")
    public String paymentInfo_OK(@PathVariable int id) {

        return paymentService.paymentInfo_OK(id) + "\t" + "ServerPort:" + serverPort;
    }

    @GetMapping("/hystrix/TimeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable int id) {

        return paymentService.paymentInfo_TimeOut(id) + "\t" + "ServerPort:" + serverPort;
    }

    @GetMapping("/hystrix/checkout/{id}")
    public String paymentInfo_Checkout(@PathVariable int id) {

        return paymentService.paymentCircuitBreaker(id) + "\t" + "ServerPort:" + serverPort;
    }
}