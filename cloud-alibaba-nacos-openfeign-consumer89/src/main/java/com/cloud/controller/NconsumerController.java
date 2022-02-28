package com.cloud.controller;

import com.cloud.service.OpenfeignNacosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NconsumerController {
    @Autowired
    OpenfeignNacosService openfeignNacosService;
    @Value("${service-url.nacos-user-service}")
    String myurl;
    @GetMapping("/nacos/consumer/ok/{id}")
    public String ok(@PathVariable("id")int id){

        return openfeignNacosService.ok(id);
    }
}
