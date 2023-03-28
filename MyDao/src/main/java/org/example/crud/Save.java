package org.example.crud;

import org.example.dao.MyListDao;
import org.example.view.*;
import org.example.domain.*;
import java.util.*;

public class Save {

    Scanner input = new Scanner(System.in); 

    MyListDao myListDao = new MyListDao();
    PrintData printData = new PrintData();

    public void setAllOfData(Person person) {
        String data = input.nextLine();
        person.setName(data.split(",")[0]); 
        person.setBirthday(data.split(",")[1]);
        person.setIntro(data.split(",")[2]);
        System.out.println(person.getName() + person.getBirthday() + person.getIntro());
    }

    public void printSavedData() {
        System.out.println("size: " + myListDao.getPeopleList().size());

        System.out.println("데이터 저장 결과입니다.");
        printData.printName(myListDao.getPeopleList().size()-1);
        printData.printAge(myListDao.getPeopleList().size()-1);
        printData.printBirthday(myListDao.getPeopleList().size()-1);
        printData.printIntro(myListDao.getPeopleList().size()-1);
    }
}
