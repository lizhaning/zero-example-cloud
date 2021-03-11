package org.zerofwk.example.cloud.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zerofwk.example.cloud.payment.service.IPaymentHystrixService;

import javax.annotation.Resource;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/10 18:08
 */
@RestController
public class PaymentHystrixController {

    @Resource
    private IPaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoOk(id);
    }
    @GetMapping(value = "/payment/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id){
       return paymentHystrixService.paymentInfoTimeout(id);
    }
}
