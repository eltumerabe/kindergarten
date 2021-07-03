package com.mar.service;

import com.mar.dao.UserDao;
import com.mar.model.User;
import com.mar.model.UserBO;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public boolean saveUserToDB(User user) {
        boolean isSaved = false;
        // convert user to userBo
        UserBO userBO = this.convertToUserBo(user);
        // insert the user to db
        isSaved = userDao.saveUser(userBO);
        return isSaved;
    }

    public User getUser(String email) {
        UserDao userDao = new UserDao();
        User user = userDao.findUser(email);
        return user;
    }

    public User loginUser(User user) {
        UserBO userBO = new UserBO();
        userBO.setEmail(user.getEmail());
        userBO.setPassword(user.getPassword());
        User userDetails = userDao.doLogin(userBO);
        return userDetails;
    }
    public boolean modifyPassword(String newPassword,int userId){
        boolean isModified = false;
        isModified = userDao.updatePassword(newPassword,userId);
        return isModified;
    }

    public UserBO convertToUserBo(User user) {
        UserBO userBO = new UserBO();
        userBO.setUsername(user.getUsername());
        userBO.setPassword(user.getPassword());
        userBO.setEmail(user.getEmail());
        userBO.setRole(user.getRole());
        return userBO;
    }
}