package org.example.springcloud.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.pojo.entity.Payment;
import org.example.springcloud.result.CommonResult;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
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

    // private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

/*    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {

        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }*/

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable Long id) {
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("status:{}", responseEntity.getStatusCode());
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(444, "请求失败");
        }
    }

    @GetMapping("/getDiscoveryClient")
    public Object getDiscoveryClient() {

        // 打印Services信息
        discoveryClient.getServices().forEach(s -> log.info("Services:" + s));

        // 打印CLOUD-PAYMENT-SERVICE服务信息
        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE").forEach(instance ->
                log.info("InstanceId:{}" + "\t" + "Host:{}" + "\t" + "Port:{}" + "\t" + "Uri:{}",
                        instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri()
                )
        );

        return this.discoveryClient;
    }
}
