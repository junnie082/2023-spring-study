package org.example.view;

import org.example.dao.*;

public class PrintData {

    MyListDao myListDao = new MyListDao();

    public void printName(int index) {
        System.out.print("이름: [" + myListDao.getPeopleList().get(index).getName() + "], ");
    }

    public void printAge(int index) {
        System.out.print("나이: [" + myListDao.getPeopleList().get(index).getAge() + "], ");
    }

    public void printBirthday(int index) {
        System.out.println("생일: [" + myListDao.getPeopleList().get(index).getBirthday() + "]");
    }

    public void printIntro(int index) {
        System.out.println("자기소개: [" + myListDao.getPeopleList().get(index).getIntro() + "]");
    }
}
