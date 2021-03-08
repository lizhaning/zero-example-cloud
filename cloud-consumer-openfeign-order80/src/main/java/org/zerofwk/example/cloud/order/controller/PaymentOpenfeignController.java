package org.zerofwk.example.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zerofwk.example.cloud.entity.CommonResult;
import org.zerofwk.example.cloud.entity.Payment;
import org.zerofwk.example.cloud.order.service.PaymentOpenfeignService;

import javax.annotation.Resource;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 23:02
 */
@RestController
@Slf4j
public class PaymentOpenfeignController {
    @Resource
    private PaymentOpenfeignService paymentOpenfeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentOpenfeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String paymentTimeout(){
        return paymentOpenfeignService.paymentTimeout();
    }
}
