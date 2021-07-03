package com.mar.dao;

import com.mar.model.Child;
import com.mar.model.ChildBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChildDao {
    private static final String INSERT_CHILD = "INSERT INTO childs (first_name,last_name,age,father_no) VALUES (?,?,?,?)";
    private static final String GET_CHILD = "SELECT * FROM childs WHERE child_id = ?";
    private static final String GET_ALL_CHILD = "SELECT * FROM childs";
    private static final String DELETE_CHILD = "DELETE FROM childs WHERE child_id = ?";

    private Connection connection;

    public ChildDao() {
        this.connection = ConnectionFactory.getConnection();
    }

    public boolean saveChild(ChildBO childBO) {
        boolean isSaved = false;
        if (null == connection) {
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_CHILD);
            ps.setString(1, childBO.getFirst_name());
            ps.setString(2, childBO.getLast_name());
            ps.setInt(3, childBO.getAge());
            ps.setString(4, childBO.getFather_no());
            int i = ps.executeUpdate();
            if (i != 0) {
                isSaved = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    public Child findChild(int childId) {
        Child child = null;
        if (null != connection) {
            this.connection = connection;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(GET_CHILD);
            ps.setInt(1,childId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                child = this.getChild(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return child;
    }

    public List<Child> findAll() {
        List<Child> childs = new ArrayList<Child>();
        if (null == connection) {
            this.connection = connection;
        }

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_CHILD);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Child child = this.getChild(resultSet);
                childs.add(child);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return childs;
    }
    public boolean deleteChild(int childId){
        boolean isDeleted = false;
        if (null != connection){
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CHILD);
            ps.setInt(1,childId);
            int i = ps.executeUpdate();
            if (i != 0){
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public Child getChild(ResultSet resultSet) {
        Child child = new Child();
        try {
            child.setChildId(resultSet.getInt("child_id"));
            child.setFirstName(resultSet.getString("first_name"));
            child.setLastName(resultSet.getString("last_name"));
            child.setAge(resultSet.getInt("age"));
            child.setFatherNo(resultSet.getString("father_no"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return child;
    }
}
