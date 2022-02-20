package com.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T>{
    private int code;
    private String status;
    private T data;

    public CommonResult(int code,String status){
        this(code,status,null);
    }
}
