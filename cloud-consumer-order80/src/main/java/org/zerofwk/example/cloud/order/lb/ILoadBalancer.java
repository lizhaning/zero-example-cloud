package org.zerofwk.example.cloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 19:01
 */
public interface ILoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
