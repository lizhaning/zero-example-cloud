package org.zerofwk.example.cloud.order.service;

import org.springframework.stereotype.Service;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/11 14:41
 */
@Service
public class OrderPaymentFallbackService implements OrderHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "-----OrderPaymentFallbackService fallback-paymentInfoOk ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----OrderPaymentFallbackService fallback-paymentInfoTimeOut ,o(╥﹏╥)o";
    }
}
