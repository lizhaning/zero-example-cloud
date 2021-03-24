package org.zerofwk.example.aliyuncloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String testA() {
        return "testA: " + RandomStringUtils.randomAlphanumeric(20);
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t,------testB");
        return "testB: " + RandomStringUtils.randomAlphanumeric(20);
    }

    @GetMapping("/testC")
    public String testC() {
        return "testC: " + RandomStringUtils.randomAlphanumeric(20);
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = "testD: " + RandomStringUtils.randomAlphanumeric(20);
        int age = 10 / 0;
        return result;
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "blockHandlerForTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        //int age = 10/0;
        return "------testHotKey";
    }

    public String blockHandlerForTestHotKey(String p1, String p2, BlockException exception) {
        //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
        return "------blockHandlerForTestHotKey,不错";
    }
}
