package org.zerofwk.example.cloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/8 19:02
 */
@Component
public class MyLoadBalancer implements ILoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current,next;
        do{
            current = atomicInteger.get();
            next = current>=Integer.MAX_VALUE?0:current+1;
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.printf("当前第{%s}访问.\n",next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
