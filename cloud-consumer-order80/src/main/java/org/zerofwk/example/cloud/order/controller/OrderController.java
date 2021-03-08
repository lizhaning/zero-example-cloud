package org.zerofwk.example.cloud.order.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.zerofwk.example.cloud.entity.CommonResult;
import org.zerofwk.example.cloud.entity.Payment;
import org.zerofwk.example.cloud.order.lb.ILoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/5 13:48
 */
@RestController
public class OrderController {

    //    public static final String PAYMENT_URL = "http://localhost:8001";//单机版
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ILoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        System.out.println(payment.toString());
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/paymentEntity/get/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful())
            return forEntity.getBody();
        else
            return new CommonResult<>(456, "方法调用出错");
    }

    @GetMapping("/consumer/payment/mylb")
    public String paymentMylb() {
        List<ServiceInstance> listInstances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT-SERVICE");
        if (listInstances == null || listInstances.size() < 0) {
            return null;
        }

        ServiceInstance instance = loadBalancer.instances(listInstances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
