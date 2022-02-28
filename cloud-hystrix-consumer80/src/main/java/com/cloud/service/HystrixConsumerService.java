package com.cloud.service;

import com.cloud.entity.CommonResult;
import com.cloud.entity.People;
import com.cloud.service.impl.FallbackHystrixConsumer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PRODUCER-SERVICE",fallback = FallbackHystrixConsumer.class)
public interface HystrixConsumerService {

    @GetMapping("/hystrix/producer/ok/{id}")
    public String ok(@PathVariable("id") int id);

    @GetMapping("/hystrix/producer/timeout/{id}")
    public String timeout(@PathVariable("id") int id);

}
