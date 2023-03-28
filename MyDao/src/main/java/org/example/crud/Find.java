package org.example.crud;

import org.example.dao.*;
import org.example.view.PrintData;

public class Find {

    MyListDao myListDao = new MyListDao();

    public void findByName(String name) {
        Find find = new Find(); 
        try {
            find.findPerson(name);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 해당 데이터가 없습니다.");
        }
    
    }

    private void findPerson(String name) {
        Find find = new Find();
        for (int i = 0; i < myListDao.getPeopleList().size(); i++) {
            if (myListDao.getPeopleList().get(i).getName().contains(name)) {
                find.printData(i);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    private void printData(int i) {
        PrintData printData = new PrintData();
        System.out.println("데이터 조회 결과입니다.");
        printData.printName(i);
        printData.printAge(i);
        printData.printBirthday(i);
        printData.printIntro(i);
    }

   
}
