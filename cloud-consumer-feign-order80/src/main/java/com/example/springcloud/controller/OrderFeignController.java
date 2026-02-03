package com.example.springcloud.controller;

import com.example.springcloud.service.OrderFeignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.pojo.entity.Payment;
import org.example.springcloud.result.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/7/4 15:14
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    private final OrderFeignService orderFeignService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {

        return orderFeignService.getPaymentById(id);
    }

    @GetMapping("/timeout")
    public CommonResult<Payment> paymentFeignTimeOut() {

        String port = orderFeignService.paymentFeignTimeOut();

        log.info("服务端口:{}", port);

        return new CommonResult<>(200, port);
    }
}
