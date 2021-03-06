package org.zerofwk.example.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004App {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004App.class,args);
    }
}
