package org.zerofwk.example.cloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/15 18:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClient3366App {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366App.class, args);
    }
}
