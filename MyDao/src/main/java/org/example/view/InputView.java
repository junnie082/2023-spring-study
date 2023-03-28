package org.example.view;

import java.util.*;

import org.example.work.*;

public class InputView {
    
    Scanner input = new Scanner(System.in); 

    public void inputStart() {
        InputView inputView = new InputView();
        inputView.setNameOfDB();
        inputView.selectWorkType();
    }

    private void setNameOfDB() {
        Work work = new Work(); 
        System.out.println("접근할 데이터베이스 이름을 입력해주세요. (LIST, MAP)");
        String nameOfDB = input.nextLine();
        work.setNameOfDB(nameOfDB);
    }   

    private void selectWorkType() {
        Work work = new Work(); 
        System.out.println("어떤 작업을 할 지 정해주세요. (SAVE: 1, FIND: 2, UPDATE: 3, DELETE: 4)");
        int workType = input.nextInt();
        work.setWorkType(workType);
        work.startWorking();
    }

    public void askContinue() {
        int exit;
        System.out.println("계속하시겠습니까? (CONTINUE: 0, EXIT: 1)");
        exit = input.nextInt();

        if (exit == 1) System.exit(0);
    }
}
