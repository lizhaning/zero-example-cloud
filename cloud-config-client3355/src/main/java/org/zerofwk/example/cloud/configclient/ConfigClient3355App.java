package org.zerofwk.example.cloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/13 21:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClient3355App {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355App.class, args);
    }
}
