package org.zerofwk.example.cloud.order.config;

import feign.Feign;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 23:39
 */
@Configuration
public class OpenfeignConfig {
    @Bean
    Logger.Level getFeignLogLevel(){
        return Logger.Level.FULL;
    }
}
