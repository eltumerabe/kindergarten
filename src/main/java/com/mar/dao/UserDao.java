package com.mar.dao;

import com.mar.model.User;
import com.mar.model.UserBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static final String INSERT_USER = "INSERT INTO users(username,email,password,role) VALUES (?,?,?,?)";
    public static final String CHECK_LOGIN = "SELECT * FROM users WHERE email = ? AND password = ?";
    public static final String GET_USER = "SELECT * FROM users WHERE email = ?";
    public static final String UPDATE_PASSWORD = "UPDATE users SET password = ?  WHERE user_id = ?";
    private Connection connection;

    public UserDao() {
        this.connection = ConnectionFactory.getConnection();
    }

    public boolean saveUser(UserBO userBO) {
        boolean isSaveed = false;
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER);
            if (null != ps && null != userBO) {
                ps.setString(1, userBO.getUsername());
                ps.setString(2, userBO.getEmail());
                ps.setString(3, userBO.getPassword());
                ps.setString(4, userBO.getRole());
                int i = ps.executeUpdate();
                if (i != 0) {
                    isSaveed = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaveed;
    }

    public User doLogin(UserBO userBO) {
        User user = null;
        if (null != connection) {
            this.connection = ConnectionFactory.getConnection();
        }
        assert this.connection != null;
        try {
            PreparedStatement ps = this.connection.prepareStatement(CHECK_LOGIN);
            if (null != ps && null != userBO) {
                ps.setString(1, userBO.getEmail());
                ps.setString(2, userBO.getPassword());
                ResultSet resultSet = ps.executeQuery();
                if (null != resultSet) {
                    while (resultSet.next()) {
                        user = new User();
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setRole(resultSet.getString("role"));
                        user.setEmail(resultSet.getString("email"));
                        user.setLoginStatus(true);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User findUser(String email) {
        User user = new User();
        if (null != connection){
            connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(GET_USER);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setLoginStatus(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public boolean updatePassword(String newPassword,int userId){
        boolean isUpdated = false;
        if (null != connection){
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PASSWORD);
            ps.setString(1,newPassword);
            ps.setInt(2,userId);
            int i = ps.executeUpdate();
            if ( i != 0){
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}