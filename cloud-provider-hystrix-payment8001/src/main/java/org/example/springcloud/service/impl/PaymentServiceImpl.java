package org.example.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/7/6 17:19
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {

        return "线程池:" + Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="4000")
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        // int age = 10 / 0;
        try {
              Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "线程池:" + Thread.currentThread().getName();
    }

    /**
     * paymentInfo_TimeOut 服务降级
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id) {

        return "线程池:" + Thread.currentThread().getName() + "\t" + "系统繁忙请稍后再试!(paymentInfo_TimeOutHandler)";
    }

/*    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  // 失败率达到多少开启服务熔断
    })*/
    @Override
    public String paymentCircuitBreaker(Integer id) {

        if (id < 0 ) {
            throw new RuntimeException("ID 不能是负数!");
        }

        String serialNumber = IdUtil.simpleUUID();


        return "线程池:" + Thread.currentThread().getName() + "\t" + "调用成功流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {

        return "ID 不能是负数, 请稍后再试...";
    }
}
