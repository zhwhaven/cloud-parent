package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

//    public static final String PRIMARY_URL="http://localhost:8001";
   public static final String PRIMARY_URL="http://CLOUD-PRODUCER-SERVICE";

    public
    @Autowired
    RestTemplate restTemplate;
    @PostMapping("/consumer/add")
    public CommonResult add(People people) {
        //进行了修改
       // System.out.println(people);
        return restTemplate.postForObject(PRIMARY_URL+"/producer/add",people,CommonResult.class);

    }

    @GetMapping("/consumer/select/{id}")
    public CommonResult<People> select(@PathVariable("id") int id){
        return restTemplate.getForObject(PRIMARY_URL+"/producer/select/"+id,CommonResult.class);

    }
}
