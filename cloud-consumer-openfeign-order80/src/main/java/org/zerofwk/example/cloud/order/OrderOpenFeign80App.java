package org.zerofwk.example.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 23:01
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeign80App {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeign80App.class, args);
    }
}
