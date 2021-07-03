package com.mar.service;

import com.mar.dao.ChildDao;
import com.mar.model.Child;
import com.mar.model.ChildBO;

import java.util.List;

public class ChildService {
    private ChildDao childDao;

    public ChildService() {
        this.childDao = new ChildDao();
    }

    public boolean saveChildToDB(Child child) {
        boolean isSaved = false;
        // convert user to userBo
        ChildBO childBO = this.convetToChildBO(child);
        // insert the user to db
        isSaved = childDao.saveChild(childBO);
        return isSaved;
    }

    public Child getChild(int childId) {
        Child child = childDao.findChild(childId);
        return child;
    }
    public boolean removeChild(int childId){
        return childDao.deleteChild(childId);
    }

    public List<Child> getAllChilds() {
        List<Child> childs = childDao.findAll();
        return childs;
    }

    public ChildBO convetToChildBO(Child child) {
        ChildBO childBO = new ChildBO();
        childBO.setFirst_name(child.getFirstName());
        childBO.setLast_name(child.getLastName());
        childBO.setAge(child.getAge());
        childBO.setFather_no(child.getFatherNo());
        return childBO;
    }
}
