package com.cloud.service;

import com.cloud.entity.People;

public interface PeopleService {
    public int addPeople(People people);
    public People selectPeople(int id);
}
