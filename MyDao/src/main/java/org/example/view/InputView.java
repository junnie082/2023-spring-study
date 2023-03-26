package org.example.view;

import java.util.*;

import org.example.dao.MyListDao;
import org.example.domain.*;
import org.example.view.*;
import org.example.work.*;

public class InputView {
    
    Scanner input = new Scanner(System.in); 

    // static 으로 설정해 주어야 다른 클래스에서도 접근 가능. 
    private static String nameOfDB;
    private static int workType;

    public String getNameOfDB() {
        return this.nameOfDB;
    }

    public int getWorkType() {
        return this.workType;
    }

    public void inputStart() {
        InputView inputView = new InputView();
        inputView.setNameOfDB();
        inputView.selectWorkType();
    }

    private void setNameOfDB() {
        System.out.println("접근할 데이터베이스 이름을 입력해주세요. (LIST, MAP)");
        this.nameOfDB = input.nextLine();
    }   

    private void selectWorkType() {
        System.out.println("어떤 작업을 할 지 정해주세요. (SAVE: 1, FIND: 2, UPDATE: 3, DELETE: 4)");
        this.workType = input.nextInt(); 
        Work work = new Work();  
        work.startWorking();
    }

    public void askContinue() {
        int exit;
        System.out.println("계속하시겠습니까? (CONTINUE: 0, EXIT: 1)");
        exit = input.nextInt();

        if (exit == 1) System.exit(0);
    }
}
