package org.zerofwk.example.cloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 18:56
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myIRule(){
        return new RandomRule();
    }
}
