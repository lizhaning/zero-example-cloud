package org.zerofwk.example.aliyuncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/23 16:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9003App {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9003App.class, args);
    }
}
