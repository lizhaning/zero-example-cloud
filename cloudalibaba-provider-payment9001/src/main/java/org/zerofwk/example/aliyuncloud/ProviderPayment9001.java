package org.zerofwk.example.aliyuncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/19 12:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9001.class, args);
    }
}
