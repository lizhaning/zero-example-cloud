package org.zerofwk.example.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zerofwk.example.cloud.entity.CommonResult;
import org.zerofwk.example.cloud.entity.Payment;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 23:01
 */
@Component
@FeignClient(value = "cloud-provider-payment-service")
public interface PaymentOpenfeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    public String paymentTimeout();
}
