package org.zerofwk.example.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/12 13:27
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001App {
    public static void main(String[] args){
      SpringApplication.run(HystrixDashboard9001App.class,args);
    }
}
