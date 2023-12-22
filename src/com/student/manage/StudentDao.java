package com.student.manage;

import java.sql.*;
import java.time.Period;

public class StudentDao {
    public static boolean insertStudentToDB(Student st){

        boolean flag = false;
        try{
            // jdbc code here
            Connection con = ConnectionProvider.createConn();
            String q = "insert into Student (sname , sphone , scity) values(?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,st.getStudentName());
            pstmt.setString(2,st.getStudentPhone());
            pstmt.setString(3,st.getStudentCity());

            // finally execute the prepared statement
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteStudent(int sid) {
        boolean flag = false;
        try{
            // jdbc code here
            Connection con = ConnectionProvider.createConn();
            String q = "delete from Student where sid=?";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1,sid);

            // finally execute the prepared statement
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void displayStudents() {
        try{
            // jdbc code here
            Connection con = ConnectionProvider.createConn();
            String q = "select * from Student;";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while(set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);

                System.out.println("Id "+ id);
                System.out.println("Name "+ name);
                System.out.println("Phone "+phone);
                System.out.println("City "+city);

                System.out.println("=================================================");

            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean updateStudentCity(int sid,String city) throws SQLException {
        boolean flag = false;

        try {
                Connection con = ConnectionProvider.createConn();
                String q = "Update Student Set scity=? where sid="+sid;
                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setString(1,city);

                pstmt.executeUpdate();
                flag = true;
        }catch (Exception e){

            e.printStackTrace();
        }
        return flag;
    }

    public static boolean updateStudentPhone(int sid, String phone) {
        boolean flag = false;

        try {
            Connection con = ConnectionProvider.createConn();
            String q = "Update Student Set sphone=? where sid="+sid;
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,phone);

            pstmt.executeUpdate();
            flag = true;
        }catch (Exception e){

            e.printStackTrace();
        }
        return flag;
    }
}
