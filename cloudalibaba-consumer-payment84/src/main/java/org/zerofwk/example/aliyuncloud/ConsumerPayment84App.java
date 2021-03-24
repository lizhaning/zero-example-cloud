package org.zerofwk.example.aliyuncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/23 16:42
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerPayment84App {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerPayment84App.class, args);
    }
}
