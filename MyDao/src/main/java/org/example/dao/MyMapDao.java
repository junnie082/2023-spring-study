package org.example.dao;

import org.example.domain.Person;

import java.util.Map;

public class MyMapDao implements MyDao {

    //key 값은 마음대로 변경 가능
    private final Map<Object, Person> peopleData;
}
