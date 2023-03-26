package org.example.dao;

import org.example.domain.Person;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MyListDao implements MyDao {

    private static List<Person> peopleList = new ArrayList<Person>(); 
    //private final List<Person> peopleList = null;  이렇게 해놔서 계속 오류 먹음. 
    
    // MyListDao myListDao = new MyListDao();

    Scanner input = new Scanner(System.in); 

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public void printSavedData() {
        MyListDao myListDao = new MyListDao();
        System.out.println("size: " + peopleList.size());

        System.out.println("데이터 저장 결과입니다.");
        myListDao.printName(peopleList.size()-1);
        myListDao.printAge(peopleList.size()-1);
        myListDao.printBirthday(peopleList.size()-1);
        myListDao.printIntro(peopleList.size()-1);
    }

    @Override
    public Person save() {
        Person person = new Person();
        MyListDao myListDao = new MyListDao();
        System.out.println("저장할 데이터를 입력해주세요.");
        myListDao.setAllOfData(person);
        peopleList.add(person);  // 여기서 peopleList.size() 찍어보면 1 인데, 왜 printSavedData() 메서드에서는 0 이라고 나오지?
        // private final List<Person> peopleList = new ArrayList<Person>(); 을
        // private static List<Person> peopleList = new ArrayList<Person>(); 으로 바꾸니까 되네...
        System.out.println("size: " + peopleList.size());

        myListDao.printSavedData();
        return person; 
    }



    private void setAllOfData(Person person) {
        String data = input.nextLine();
        person.setName(data.split(",")[0]); 
        person.setBirthday(data.split(",")[1]);
        person.setIntro(data.split(",")[2]);
    }

    private void printName(int index) {
        System.out.print("이름: [" + peopleList.get(index).getName() + "], ");
    }

    private void printAge(int index) {
        System.out.print("나이: [" + peopleList.get(index).getAge() + "], ");
    }

    private void printBirthday(int index) {
        System.out.println("생일: [" + peopleList.get(index).getBirthday() + "]");
    }

    private void printIntro(int index) {
        System.out.println("자기소개: [" + peopleList.get(index).getIntro() + "]");
    }


    @Override
    public Person find() {
        MyListDao myListDao = new MyListDao();
        Person person = new Person(); 
        System.out.println("조회할 이름을 입력해주세요.");
        String name = input.nextLine();
        myListDao.findByName(name);
        return person; 
    } 

    private void findByName(String name) {
        MyListDao myListDao = new MyListDao();
        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).getName().contains(name)) {
                myListDao.printData(i);
                return;
            }
        }
    }

    private void printData(int i) {
        MyListDao myListDao = new MyListDao();
        System.out.println("데이터 조회 결과입니다.");
        myListDao.printName(i);
        myListDao.printAge(i);
        myListDao.printBirthday(i);
        myListDao.printIntro(i);
    }


    
    @Override
    public Person update() {
        MyListDao myListDao = new MyListDao();
        Person person = new Person();
        System.out.println("수정할 이름을 입력해주세요.");
        String name = input.nextLine();
        myListDao.modify(myListDao.getIndex(name));
        return person; 
    }

    private int getIndex(String name) {
      
        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).getName().contains(name)) {
                return i; 
            }
        }
        System.out.println("[ERROR] 해당 이름은 존재하지 않습니다.");
        return -1;
    }

    private void modify(int index) {
        MyListDao myListDao = new MyListDao();
        System.out.println("수정할 데이터를 입력해주세요.");
        String data = input.nextLine();
        int previousAge = peopleList.get(index).getAge();
        String previousBirthday = peopleList.get(index).getBirthday();
        String previousIntro = peopleList.get(index).getIntro();
        peopleList.get(index).setBirthday(data.split(",")[0]); 
        peopleList.get(index).setIntro(data.split(",")[1]);
        myListDao.printResult(index, previousAge, previousBirthday, previousIntro);
    }

    private void printResult(int index, int previousAge, String previousBirthday, String previousIntro) {
        MyListDao myListDao = new MyListDao();
        myListDao.printName(index);
        System.out.print("나이: [" + previousAge + "] -> " + peopleList.get(index).getAge() + "], ");
        System.out.println("생일: [" + previousBirthday +"] -> [" + peopleList.get(index).getBirthday() + "]");
        System.out.println("자기소개: [" + previousIntro + "] -> [" + peopleList.get(index).getIntro() + "]");
    }

    @Override
    public void delete() {
        MyListDao myListDao = new MyListDao();
        System.out.println("삭제할 데이터의 이름을 입력해주세요.");
        String name = input.nextLine();
        myListDao.cutData(myListDao.getIndex(name));
    }

    private void cutData(int index) {
        peopleList.remove(index);
    }

}