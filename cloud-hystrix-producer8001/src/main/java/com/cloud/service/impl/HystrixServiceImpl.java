package com.cloud.service.impl;

import com.cloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Component
public class HystrixServiceImpl implements HystrixService {

    @Override
    public String ok(int i) {
        return "into ok service";
    }

    @Override
   @HystrixCommand(fallbackMethod = "fallback1",commandProperties = {
           @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
   })
    public String timeout(int i) {
        try {
            int time=5;
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "into timeout service";
    }


    @HystrixCommand(fallbackMethod = "fallback1",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//达到一定的请求次数后熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//多长时间后开始恢复
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//容错比

    })
    @Override
    public String cbreak(int i) {
        if(i<0){
            throw new RuntimeException("** < 0");
        }
        return "cbrek service into success";
    }

    //参数要与原方法一致，返回类型也要一致
    public String fallback1(int i) {

        return "can not into service,wait...";
    }


}
