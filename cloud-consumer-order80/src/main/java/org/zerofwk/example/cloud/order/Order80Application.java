package org.zerofwk.example.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.zerofwk.example.cloud.myrule.MyRule;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/5 13:47
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT-SERVICE",configuration = MyRule.class)
public class Order80Application {
    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class, args);
    }
}
