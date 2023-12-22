package com.student.manage;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection conn ;
    public static Connection createConn(){
        try{
            //(1). Load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //(2). Create the connection
            String url = "jdbc:mysql://localhost:3306/student_manage";
            String user = "root";
            String password = "Kuldeep@123";
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
