package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.entity.People;
import com.cloud.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PeopleController {

    @Autowired
    PeopleService peopleService;
    @Value("${server.port}")
    String port;
    @PostMapping("/producer/add")
    public CommonResult add(@RequestBody People people) {
        System.out.println("producer："+people);
        try {
            peopleService.addPeople(people);
            return new CommonResult(200,"add success",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(404,"add fail",null);
        }

    }

    @GetMapping("/producer/select/{id}")
    public CommonResult<People> select(@PathVariable("id") int id){
        System.out.println("port="+port);
        People people = peopleService.selectPeople(id);
        return new CommonResult<People>(200,"select success",people);
    }

    @GetMapping("/producer/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    };
}
