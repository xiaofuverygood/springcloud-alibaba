package org.example.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springcloud.pojo.entity.Payment;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/3/3 14:23
 */
public interface PaymentService extends IService<Payment> {


    int create(Payment payment);

    Payment getPaymentById(Long id);
}