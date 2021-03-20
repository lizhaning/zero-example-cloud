package org.zerofwk.example.aliyuncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/20 10:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService8401App {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401App.class, args);
    }
}
