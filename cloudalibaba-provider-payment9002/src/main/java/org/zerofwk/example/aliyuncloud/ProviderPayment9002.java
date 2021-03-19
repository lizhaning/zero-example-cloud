package org.zerofwk.example.aliyuncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/19 14:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9002.class, args);
    }
}
