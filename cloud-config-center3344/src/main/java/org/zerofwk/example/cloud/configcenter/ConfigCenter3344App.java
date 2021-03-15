package org.zerofwk.example.cloud.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/13 20:21
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344App {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344App.class, args);
    }
}
