package com.cloud.service.impl;

import com.cloud.dao.PeopleMapper;
import com.cloud.entity.People;
import com.cloud.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleMapper peopleMapper;
    @Override
    public int addPeople(People people) {
        return peopleMapper.addPeople(people);
    }

    @Override
    public People selectPeople(int id) {
        return peopleMapper.selectPeople(id);
    }
}
