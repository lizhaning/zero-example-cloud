package org.zerofwk.example.cloud.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * desc:
 *
 * @Author: Administrator
 * @Date: 2021/3/4 14:28
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
