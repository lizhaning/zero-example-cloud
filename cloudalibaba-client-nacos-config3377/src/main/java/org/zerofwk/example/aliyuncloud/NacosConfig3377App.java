package org.zerofwk.example.aliyuncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/19 14:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfig3377App {
    public static void main(String[] args){
        SpringApplication.run(NacosConfig3377App.class,args);
    }
}
