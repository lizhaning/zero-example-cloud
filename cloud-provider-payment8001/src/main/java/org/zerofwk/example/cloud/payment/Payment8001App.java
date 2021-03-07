package org.zerofwk.example.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/4 11:06
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8001App {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001App.class, args);
    }
}
