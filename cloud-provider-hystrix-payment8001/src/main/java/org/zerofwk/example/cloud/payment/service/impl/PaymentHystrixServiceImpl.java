package org.zerofwk.example.cloud.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
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
        return "Thread: "+Thread.currentThread().getName()+" paymentInfoOk,id: "+id+"\t(∩_∩)O哈哈~";
    }

    @HystrixCommand(
            fallbackMethod = "paymentInfoHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @Override
    public String paymentInfoTimeout(Integer id) {
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        return "Thread: "+Thread.currentThread().getName()+" paymentInfoTimeout,id: "+id+"  o(>﹏<)o不要啊";
    }

    public String paymentInfoHandler(Integer id){
        return Thread.currentThread().getName()+"\t"+"系统繁忙，请稍后再试，id: " + id +"  o(︶︿︶)o唉";
    }
}
