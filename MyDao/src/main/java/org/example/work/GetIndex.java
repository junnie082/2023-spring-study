package org.example.work;

import org.example.dao.*;

public class GetIndex {
    
    MyListDao myListDao = new MyListDao();

    public int getIndex(String name) {
      
        for (int i = 0; i < myListDao.getPeopleList().size(); i++) {
            if (myListDao.getPeopleList().get(i).getName().contains(name)) {
                return i; 
            }
        }
        return -1;
    }
}
