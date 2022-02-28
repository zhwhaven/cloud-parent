package com.cloud.controller;

import com.cloud.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HystrixProducerController {

    @Autowired
    HystrixService hystrixService;

    @GetMapping("/hystrix/producer/ok/{id}")
    public String ok(@PathVariable("id") int id){
        System.out.println(hystrixService.ok(id)
        );
        return hystrixService.ok(id);
    }

    @GetMapping("/hystrix/producer/timeout/{id}")
    public String timeout(@PathVariable("id") int id){

        System.out.println(hystrixService.timeout(id));

        return hystrixService.timeout(id);
    }

    @GetMapping("/hystrix/producer/cbreak/{id}")
    public String cbreak(@PathVariable("id") int id){

        System.out.println(hystrixService.cbreak(id));

        return hystrixService.cbreak(id);
    }

}
