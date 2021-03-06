package org.zerofwk.example.cloud.order.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.zerofwk.example.cloud.entity.CommonResult;
import org.zerofwk.example.cloud.entity.Payment;

import javax.annotation.Resource;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/5 13:48
 */
@RestController
public class OrderController {

    //    public static final String PAYMENT_URL = "http://localhost:8001";//单机版
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        System.out.println(payment.toString());
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
