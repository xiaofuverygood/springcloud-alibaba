package com.springcloud.service;

import org.example.springcloud.pojo.entity.Payment;
import org.example.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
      @GetMapping(value = "/paymentSQL/{id}")
      CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
