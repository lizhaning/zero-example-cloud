package org.zerofwk.example.aliyuncloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/19 14:19
 */
@Configuration
public class ConsumerNacosConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRest() {
        return new RestTemplate();
    }
}
