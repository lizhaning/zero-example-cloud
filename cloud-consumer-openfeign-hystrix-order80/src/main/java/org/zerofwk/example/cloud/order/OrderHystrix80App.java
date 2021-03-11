package org.zerofwk.example.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/11 14:06
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrix80App {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrix80App.class, args);
    }
}
