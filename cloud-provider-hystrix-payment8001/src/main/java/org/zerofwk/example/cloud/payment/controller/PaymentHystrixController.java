package org.zerofwk.example.cloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PaymentHystrixController {

    @Resource
    private IPaymentHystrixService paymentHystrixService;

    private long num = 0;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        if (num > Long.MAX_VALUE) num = 0;
        log.info("request id: {},num: {}", id, num++);
        return paymentHystrixService.paymentInfoOk(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        log.info("request id: {},result: {}", id, result);
        return result;
    }
}
