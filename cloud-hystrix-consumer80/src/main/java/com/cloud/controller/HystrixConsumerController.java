package com.cloud.controller;

import com.cloud.service.HystrixConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "fallback1")
public class HystrixConsumerController {

    @Autowired
    HystrixConsumerService hystrixConsumerService;


    @GetMapping("/hystrix/consumer/ok/{id}")
//    @HystrixCommand
    public String ok(@PathVariable("id") int id){

        return hystrixConsumerService.ok(id);
    }

//    @HystrixCommand(fallbackMethod = "fallback1",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })

    @GetMapping("/hystrix/consumer/timeout/{id}")
//    @HystrixCommand
    public String timeout(@PathVariable("id") int id){
        return hystrixConsumerService.timeout(1);
    }

//    public String fallback1(){
//        return "服务器繁忙中，等待ing";
//    }
}
