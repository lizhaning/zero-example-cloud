package org.zerofwk.example.aliyuncloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/20 10:13
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(1200);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return "testA: "+ RandomStringUtils.randomAlphanumeric(20);
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t,------testB");
        return "testB: "+ RandomStringUtils.randomAlphanumeric(20);
    }
    @GetMapping("/testC")
    public String testC(){
        return "testC: "+ RandomStringUtils.randomAlphanumeric(20);
    }
}
