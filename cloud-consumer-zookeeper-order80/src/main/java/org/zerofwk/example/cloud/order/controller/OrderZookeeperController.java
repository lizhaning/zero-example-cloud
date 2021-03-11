package org.zerofwk.example.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 15:45
 */
@RestController
@Slf4j
public class OrderZookeeperController {
    private static final String PAYMENT_URL = "http://cloud-provider-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentzk(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
