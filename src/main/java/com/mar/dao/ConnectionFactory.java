package com.mar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost/kindergarten?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "mysqldb123";


    public static Connection connection;
    public static Connection getConnection(){
        if (null == connection){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USER,PASS);
                return connection;
            }
            catch (SQLException ex){
                System.out.println("db connection error");
            }
            catch (ClassNotFoundException ex){
                System.out.println("driver class not found");
            }
        }
        return connection;
    }
}