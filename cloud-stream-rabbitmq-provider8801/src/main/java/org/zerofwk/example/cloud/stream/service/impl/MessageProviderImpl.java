package org.zerofwk.example.cloud.stream.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.zerofwk.example.cloud.stream.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/16 10:38
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    @Qualifier("output")
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String randStr = RandomStringUtils.randomAlphanumeric(20);
        boolean b = messageChannel.send(MessageBuilder.withPayload(randStr).build());
        log.info("provider 8801 send message: {},result: {}",randStr,b);
        return randStr;
    }
}
