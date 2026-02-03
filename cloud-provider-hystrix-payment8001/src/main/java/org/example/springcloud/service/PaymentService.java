package org.example.springcloud.service;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/7/25 09:55
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
