package org.zerofwk.example.aliyuncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/23 16:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9004App {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9004App.class, args);
    }
}
