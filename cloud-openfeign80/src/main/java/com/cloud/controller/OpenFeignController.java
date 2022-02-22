package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.entity.People;
import com.cloud.service.OpenFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OpenFeignController {

    @Resource
    OpenFeignService openFeignService;

    @PostMapping("/openfeign/add")
    public CommonResult add(@RequestBody People people){
        return openFeignService.add(people);
    };

    @GetMapping("/openfeign/select/{id}")
    public CommonResult<People> select(@PathVariable("id")int id){
        return openFeignService.select(id);
    }
}
