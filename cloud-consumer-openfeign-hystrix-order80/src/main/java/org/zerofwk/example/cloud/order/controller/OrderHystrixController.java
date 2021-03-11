package org.zerofwk.example.cloud.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zerofwk.example.cloud.order.service.OrderHystrixService;

import javax.annotation.Resource;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/11 14:07
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService hystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        log.info("/consumer/payment/hystrix/ok/id: {}", id);
        return hystrixService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        log.info("/consumer/payment/hystrix/timeout/id:{} ", id);
        return hystrixService.paymentInfoTimeOut(id);
    }

    public String paymentHystrixOrderHandler(Integer id) {
        return "消费端80服务，支付系统8001正忙，请检查后，稍后再试。random: " + Math.random() + ", id: " + id;
    }

    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
