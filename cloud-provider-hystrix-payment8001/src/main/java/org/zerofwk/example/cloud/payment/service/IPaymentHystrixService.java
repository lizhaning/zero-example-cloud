package org.zerofwk.example.cloud.payment.service;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/10 18:00
 */
public interface IPaymentHystrixService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeout(Integer id);
}
