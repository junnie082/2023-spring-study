package org.example.crud;

import java.util.Scanner;

import org.example.dao.*;
import org.example.view.*;

public class Update {

    Scanner input = new Scanner(System.in); 

    MyListDao myListDao = new MyListDao();

    public void modify(int index) {
        Update update = new Update(); 
        System.out.println("수정할 데이터를 입력해주세요.");
        String data = input.nextLine();
        int previousAge = myListDao.getPeopleList().get(index).getAge();
        String previousBirthday = myListDao.getPeopleList().get(index).getBirthday();
        String previousIntro = myListDao.getPeopleList().get(index).getIntro();
        myListDao.getPeopleList().get(index).setBirthday(data.split(",")[0]); 
        myListDao.getPeopleList().get(index).setIntro(data.split(",")[1]);
        update.printResult(index, previousAge, previousBirthday, previousIntro);
    }

    public void printResult(int index, int previousAge, String previousBirthday, String previousIntro) {
        PrintData printData = new PrintData(); 
        printData.printName(index);
        System.out.print("나이: [" + previousAge + "] -> " + myListDao.getPeopleList().get(index).getAge() + "], ");
        System.out.println("생일: [" + previousBirthday +"] -> [" + myListDao.getPeopleList().get(index).getBirthday() + "]");
        System.out.println("자기소개: [" + previousIntro + "] -> [" + myListDao.getPeopleList().get(index).getIntro() + "]");
    }
}
