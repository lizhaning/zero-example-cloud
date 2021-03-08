package org.zerofwk.example.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 15:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZookeeper80App {
    public static void main(String[] args) {
        SpringApplication.run(OrderZookeeper80App.class, args);
    }
}
