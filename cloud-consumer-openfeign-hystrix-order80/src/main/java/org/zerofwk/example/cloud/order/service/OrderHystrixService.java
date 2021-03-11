package org.zerofwk.example.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/11 14:16
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = OrderPaymentFallbackService.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id);

}
