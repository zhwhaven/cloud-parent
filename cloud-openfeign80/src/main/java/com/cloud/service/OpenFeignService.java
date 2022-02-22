package com.cloud.service;

import com.cloud.entity.CommonResult;
import com.cloud.entity.People;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PRODUCER-SERVICE")
public interface OpenFeignService {

    @PostMapping("/producer/add")
    public CommonResult add(@RequestBody People people);

    @GetMapping("/producer/select/{id}")
    public CommonResult<People> select(@PathVariable("id")int id);

}
