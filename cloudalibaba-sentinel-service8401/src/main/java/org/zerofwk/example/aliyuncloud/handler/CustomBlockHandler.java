package org.zerofwk.example.aliyuncloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.zerofwk.example.cloud.entity.CommonResult;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/23 16:19
 */
public class CustomBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----2");
    }
}
