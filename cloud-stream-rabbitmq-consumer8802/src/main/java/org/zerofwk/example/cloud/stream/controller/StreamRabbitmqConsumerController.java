package org.zerofwk.example.cloud.stream.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/16 12:01
 */
@Service
@EnableBinding(Sink.class)
@Slf4j
public class StreamRabbitmqConsumerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("receive message: {}, from message port: {}", message.getPayload(), serverPort);
    }
}
