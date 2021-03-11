package org.zerofwk.example.cloud.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.zerofwk.example.cloud.payment.service.IPaymentHystrixService;

import java.util.concurrent.TimeUnit;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/10 18:00
 */
@Service
@Slf4j
public class PaymentHystrixServiceImpl implements IPaymentHystrixService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "Thread: " + Thread.currentThread().getName() + " paymentInfoOk,id: " + id + "\t(∩_∩)O哈哈~";
    }

    @HystrixCommand(
            fallbackMethod = "paymentInfoHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfoTimeout(Integer id) {
        //int t = 10/0;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread: " + Thread.currentThread().getName() + " paymentInfoTimeout,id: " + id + "  o(>﹏<)o不要啊";
    }

    public String paymentInfoHandler(Integer id) {
        return Thread.currentThread().getName() + "\t" + "8001系统繁忙，请稍后再试，id: " + id + "  o(︶︿︶)o唉";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(Integer dd) {
        log.info("paymentCircuitBreaker,input parameter: {}", dd);
        if (dd < 0) {
            throw new RuntimeException("dd 不能为负数.");
        }
        String serialNumber = RandomStringUtils.randomAlphanumeric(10);
        return Thread.currentThread().getName() + "\t 调用成功,流水号：" + serialNumber;
    }

    private String paymentCircuitBreakerFallback(Integer id){
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
