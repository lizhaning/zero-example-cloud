package org.zerofwk.example.cloud.stream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerofwk.example.cloud.stream.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/16 11:05
 */
@RestController
public class StreamRabbitmqProviderController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/stream/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
