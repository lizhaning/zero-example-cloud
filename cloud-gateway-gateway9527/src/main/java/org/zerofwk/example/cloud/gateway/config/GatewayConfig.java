package org.zerofwk.example.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/13 10:04
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("route_path_test",r->{
           return r.path("/game").uri("http://news.baidu.com/game");
        });
        routes.route("route_path_money",r-> {
            return r.path("/stock").uri("https://money.163.com/stock");
        });
        return routes.build();
    }
}
