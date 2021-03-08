package org.zerofwk.example.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZk80App {
    public static void main(String[] args) {
        SpringApplication.run(OrderZk80App.class, args);
    }
}
