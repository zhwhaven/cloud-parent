package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-producer-service")
@Component
public interface OpenfeignNacosService {
    @GetMapping("/nacos/producer/ok/{id}")
    public String ok(@PathVariable("id")int id);
}
