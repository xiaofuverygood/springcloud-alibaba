package org.example.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.springcloud.dao.PaymentMapper;
import org.example.springcloud.pojo.entity.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/3/3 14:25
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    private final PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {

        int insertReslt = paymentMapper.insert(payment);

        return insertReslt;
    }

    @Override
    public Payment getPaymentById(Long id) {

        Payment payment = paymentMapper.selectById(id);

        return payment;
    }
}