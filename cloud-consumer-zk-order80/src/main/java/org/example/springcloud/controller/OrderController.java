package org.example.springcloud.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.pojo.entity.Payment;
import org.example.springcloud.result.CommonResult;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/3/5 10:45
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/consumer")
public class OrderController {

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    private final RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {

        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
