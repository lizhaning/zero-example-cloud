package org.zerofwk.example.cloud.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.zerofwk.example.cloud.entity.CommonResult;
import org.zerofwk.example.cloud.entity.Payment;
import org.zerofwk.example.cloud.payment.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/4 14:58
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.queryById(id);
        return new CommonResult<Payment>(200, "select success， serverPort：" + serverPort, payment);
    }

    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        Payment insert = this.paymentService.insert(payment);
        return new CommonResult<>(200, "insert success， serverPort：" + serverPort, insert);
    }

    @GetMapping("queryAllByLimit")
    public CommonResult<List<Payment>> queryAllByLimit(@RequestParam(defaultValue = "0") int offset,
                                                       @RequestParam(defaultValue = "10") int limit) {
        List<Payment> payment = this.paymentService.queryAllByLimit(offset, limit);
        return new CommonResult<>(200, "select success， serverPort：" + serverPort, payment);
    }

    @GetMapping(value = "lb")
    public String paymentLb() {
        return serverPort;
    }
}
