package org.example.work;

import org.example.dao.MyListDao;
import org.example.domain.*;
import org.example.view.*;

public class Work {
    
    Person person = new Person();
    private int workType;

    //Work work = new Work(); 
    // 이걸 메서드 밖에서 하면 클래스가 무한 호출 되는 듯함. 
    public void startWorking() {
        // SAVE: 1, FIND: 2, UPDATE: 3, DELETE: 4
        InputView inputView = new InputView(); 
        String typeOfDB = inputView.getNameOfDB();
        int workType = inputView.getWorkType();
        Work work = new Work(); 
        if (typeOfDB.equals("LIST")) {  // == 과 equals 는 엄연히 다르다는 것. 
            work.workAsList(workType);
        }
        // } else if (typeOfDB == "MAP") {
        //     work.workAsMap(workType); 
        // }
    }

    private void workAsList(int workType) {
        MyListDao myListDao = new MyListDao();
        if (workType == 1) {
            System.out.print("SAVE");
            myListDao.save();
        } else if (workType == 2) {
            System.out.print("FIND");
            myListDao.find(); 
        } else if (workType == 3) {
            System.out.print("UPDATE");
            myListDao.update();
        } else if (workType == 4) {
            System.out.print("DELETE");
            myListDao.delete();
        }
    }

    // private void workAsMap(int workType) {
    //     if (workType == 1) {

    //     } else if (workType == 2) {
           
    //     } else if (workType == 3) {

    //     } else if (workType == 4) {

    //     }
    // }


    // private void printListSave() {
    //     SaveList save = new SaveList(); 
    //     save.printSavedData();
    // }

    // private void printListFind() {
    //     FindList find = new FindList();
    //     find.findByName();
    // }

    // private void printListUpdate() {

    // }

    // private void printListDelete() {

    // }

}
