package org.example.work;

import org.example.dao.MyListDao;
import org.example.domain.*;

public class Work {
    
    Person person = new Person();

    private static String nameOfDB;
    private static int workType;   

    public void setNameOfDB(String nameOfDB) {
        this.nameOfDB = nameOfDB;
    }

    public void setWorkType(int workType) {
        this.workType = workType;
    }

    public void startWorking() {
        // SAVE: 1, FIND: 2, UPDATE: 3, DELETE: 4
        Work work = new Work(); 
        if (this.nameOfDB.equals("LIST")) {  // == 과 equals 는 엄연히 다르다는 것. 
            work.workAsList(workType);
        }
        // } else if (typeOfDB == "MAP") {
        //     work.workAsMap(workType); 
        // }
    }

    private void workAsList(int workType) {
        MyListDao myListDao = new MyListDao();
        if (workType == 1) {
            myListDao.save();
        } else if (workType == 2) {
            myListDao.find(); 
        } else if (workType == 3) {
            myListDao.update();
        } else if (workType == 4) {
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
