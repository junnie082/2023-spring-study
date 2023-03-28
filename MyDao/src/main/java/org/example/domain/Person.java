package org.example.domain;

public class Person {

    private String name; 
    private int age;
    private String birthday; 
    private String intro;

    public void setName(String name) {
        this.name = name; 
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
        this.calAge(); 
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    private void calAge() {  // 이 메서드에 문제 있음. 
        System.out.println("birthday: " + this.birthday);
        System.out.println("birthday length: " + this.birthday.length()); 

        // split 이 계속 오류남. regex 를 "/" 로 하면 잘 작동이 됨. 하지만 "." 는 작동 안됨. 
        //java.lang.String.split splits on regular expressions, and . in a regular expression means "any character".

        //Try temp.split("\\."). === > 된다.. 이것 때문에 시간 많이 잡아 먹음. 
        System.out.println("birthday: " + this.birthday.split("\\.")[0]);
        int year = Integer.parseInt(this.birthday.split("\\.")[0]);
        this.age = 2023-year+1; 
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age; 
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getIntro() {
        return this.intro; 
    }
}
