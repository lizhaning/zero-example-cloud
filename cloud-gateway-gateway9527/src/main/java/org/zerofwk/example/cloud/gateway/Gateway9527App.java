package org.zerofwk.example.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/12 18:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Gateway9527App {
    public static void main(String[] args){
      SpringApplication.run(Gateway9527App.class,args);
    }
}
