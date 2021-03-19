package org.zerofwk.example.aliyuncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/19 14:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerPayment83App {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerPayment83App.class, args);
    }
}
