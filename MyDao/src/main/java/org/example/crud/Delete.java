package org.example.crud;

import org.example.dao.*;

public class Delete {

    MyListDao myListDao = new MyListDao();
    public void cutData(int index) {
        Delete delete = new Delete();
        try {
            delete.removeItem(index);
            delete.printDeleted();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 해당 데이터가 없습니다. ");
        }
    }

    private void removeItem(int index) {
        if (index == -1) {
            throw new IllegalArgumentException();
        }
        myListDao.getPeopleList().remove(index);
    }

    private void printDeleted() {
        System.out.println("데이터가 삭제 되었습니다.");
    }

}
