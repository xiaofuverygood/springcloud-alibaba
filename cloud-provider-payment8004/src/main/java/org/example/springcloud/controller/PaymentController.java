package org.example.springcloud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.pojo.entity.Payment;
import org.example.springcloud.result.CommonResult;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/3/3 16:56
 */

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {

        int createReslt = paymentService.create(payment);
        log.info("########插入结果:{}########", createReslt);

        if (createReslt > 0) {

            return new CommonResult<>(200, "插入成功," + "serverPort:" + serverPort, createReslt);
        } else {

            return new CommonResult<>(444, "插入失败," + "serverPort:" + serverPort, createReslt);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("########查询结果:{}########", payment);

        if (payment != null) {

            return new CommonResult<>(200, "查询成功," + "serverPort:" + serverPort, payment);
        } else {

            return new CommonResult<>(444, "查询失败,未找到对应的记录," + "serverPort:" + serverPort);
        }
    }
}
