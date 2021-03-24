package org.zerofwk.example.aliyuncloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerofwk.example.aliyuncloud.handler.CustomBlockHandler;
import org.zerofwk.example.cloud.entity.CommonResult;
import org.zerofwk.example.cloud.entity.Payment;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/23 15:29
 */
@RestController
public class RateLimitController {
    @GetMapping(value = "/byResource", produces = "application/json;charset=UTF-8")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按照资源名称限流测试OK", new Payment(100l, "serial-10001"));
    }

    public CommonResult<Payment> handlerException(BlockException blockException) {
        return new CommonResult<>(444, "按资源名限流测试，流控信息：" + blockException.getClass().getCanonicalName() + "\t,服务不可用。");
    }

    @GetMapping(value = "/rateLimit/byUrl", produces = "application/json;charset=UTF-8")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    @GetMapping(value = "/rateLimit/customerBlockHandler", produces = "application/json;charset=UTF-8")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}
