package org.zerofwk.example.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/13 10:49
 */
@Component
@Slf4j
public class LogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info(" LogGatewayFilter check... {}./S", RandomStringUtils.randomAlphanumeric(20));
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(StringUtils.isEmpty(uname)){
            log.info("用户名为null，请检查后再试。");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
