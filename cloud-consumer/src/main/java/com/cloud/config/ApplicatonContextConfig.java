package com.cloud.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class ApplicatonContextConfig {

    @Bean
    @LoadBalanced   //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
