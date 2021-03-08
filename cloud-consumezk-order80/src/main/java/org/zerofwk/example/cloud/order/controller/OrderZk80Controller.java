package org.zerofwk.example.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZk80Controller {

    private static final String PAYMENT_URL = "http://cloud-provider-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentzk(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
