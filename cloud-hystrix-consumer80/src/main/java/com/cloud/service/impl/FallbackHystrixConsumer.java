package com.cloud.service.impl;

import com.cloud.service.HystrixConsumerService;
import org.springframework.stereotype.Component;

@Component
public class FallbackHystrixConsumer implements HystrixConsumerService {
    @Override
    public String ok(int id) {
        return "ok service can not into ,wait...";
    }

    @Override
    public String timeout(int id) {
        return "timeout service can not into ,wait...";
    }
}
