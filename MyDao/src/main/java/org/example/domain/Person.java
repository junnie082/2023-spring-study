package org.example.domain;

public class Person {

    private static String name; 
    private static int age;
    private static String birthday; 
    private static String intro;

    public void setName(String name) {
        this.name = name; 
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        Person person = new Person(); 
        person.calAge(); 
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    private void calAge() {  // 이 메서드에 문제 있음. 
        System.out.println("birthday: " + birthday);
        System.out.println("birthday length: " + birthday.length()); 
        System.out.println("birthday: " + birthday.split("."));
        int year = Integer.parseInt(birthday.split(".")[0]);
        age = 2023-year+1; 
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age; 
    }

    public String getBirthday() {
        return birthday;
    }

    public String getIntro() {
        return intro; 
    }
}
