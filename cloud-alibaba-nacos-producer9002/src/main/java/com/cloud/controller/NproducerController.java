package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NproducerController {

    @Value("${server.port}")
    String port;
    @GetMapping("/nacos/producer/ok/{id}")
    public String ok(@PathVariable("id")int id){
        System.out.println("this is port:"+port+"---id="+id);
        return "this is port:"+port+"---id="+id;
    }
}
