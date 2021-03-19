package org.zerofwk.example.aliyuncloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/19 14:10
 */
@RestController
@Slf4j
public class ProviderPaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/get/{id}")
    public String paymentOk(@PathVariable("id") long id) {
        return " nacos provider method--> :" + serverPort + "\t ,param id: " + id;
    }
}
