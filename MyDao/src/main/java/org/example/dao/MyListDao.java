package org.example.dao;

import org.example.domain.Person;

import java.util.List;

public class MyListDao implements MyDao {

    private final List<Person> peopleList;
}
