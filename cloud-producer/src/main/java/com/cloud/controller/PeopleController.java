package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.entity.People;
import com.cloud.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PeopleController {

    @Autowired
    PeopleService peopleService;

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

    @GetMapping("/producer/select")
    public CommonResult<People> select(int id){
        People people = peopleService.selectPeople(id);
        return new CommonResult<People>(200,"select success",people);
    }
}
