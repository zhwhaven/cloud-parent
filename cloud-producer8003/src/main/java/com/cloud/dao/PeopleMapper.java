package com.cloud.dao;

import com.cloud.entity.People;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PeopleMapper {

    public int addPeople(People people);

    public People selectPeople(int id);
}
