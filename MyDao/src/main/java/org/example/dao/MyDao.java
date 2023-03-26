package org.example.dao;

import org.example.domain.Person;

public interface MyDao {
    Person save();
    Person find();
    Person update();
    void delete();
}
