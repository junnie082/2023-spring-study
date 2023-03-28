package org.example.dao;

import org.example.domain.Person;
import org.example.crud.*;
import org.example.work.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class MyListDao implements MyDao {

    private final static List<Person> peopleList = new ArrayList<Person>(); 

    Scanner input = new Scanner(System.in); 

    public List<Person> getPeopleList() {
        return peopleList;
    }

    @Override
    public Person save() {
        Person person = new Person();
        Save save = new Save(); 

        System.out.println("저장할 데이터를 입력해주세요.");
        save.setAllOfData(person);
        peopleList.add(person); 
        System.out.println("size: " + peopleList.size());
        save.printSavedData();
        return person; 
    }


    @Override
    public Person find() {
        Find find = new Find(); 
        Person person = new Person(); 

        System.out.println("조회할 이름을 입력해주세요.");
        String name = input.nextLine();
        find.findByName(name);
        return person; 
    } 


    @Override
    public Person update() {
        Update update = new Update(); 
        Person person = new Person();
        GetIndex getIndex = new GetIndex(); 

        System.out.println("수정할 이름을 입력해주세요.");
        String name = input.nextLine();
        update.modify(getIndex.getIndex(name));
        return person; 
    }

    

    @Override
    public void delete() {
        Delete delete = new Delete();
        GetIndex getIndex = new GetIndex(); 

        System.out.println("삭제할 데이터의 이름을 입력해주세요.");
        String name = input.nextLine();
        delete.cutData(getIndex.getIndex(name));
    }


}