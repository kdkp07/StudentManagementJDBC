package com.student.main;

import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("============================Welcome to Student Management App============================");
            System.out.println("");
            System.out.println("Please select one of the below choices........");
            System.out.println("");
            System.out.println("Press 1 to add the student");
            System.out.println("Press 2 to delete the student");
            System.out.println("Press 3 to view the student");
            System.out.println("Press 4 to update the student");
            System.out.println("Press 5 to exit the app");

            int choice = Integer.parseInt(br.readLine());
            if(choice==1){
                // add student
                System.out.println("Enter student name");
                String name = br.readLine();

                System.out.println("Enter student phone number");
                String phone = br.readLine();

                System.out.println("Enter student residential city name");
                String city = br.readLine();

                Student std = new Student(name,phone,city);
                boolean ans = StudentDao.insertStudentToDB(std);
                if(ans){
                    System.out.println("Student added successfully..........");
                }
                else{
                    System.out.println("Something went wrong , Please try again.........");
                }

                System.out.println(std);

            }
            else if(choice==2){
                // delete student
                System.out.println("Enter the student id");
                int sid = Integer.parseInt(br.readLine());
                boolean ans = StudentDao.deleteStudent(sid);
                if(ans){
                    System.out.println("Student with id ="+ sid +" deleted");
                }
                else{
                    System.out.println("Something went wrong , Please try again.........");
                }
            }
            else if(choice ==3){
                // view student
                StudentDao.displayStudents();
            }
            else if(choice==4){
                // update the student
                System.out.println("Enter the student id");
                int sid = Integer.parseInt(br.readLine());
                System.out.println("");
                while (true){
                    System.out.println("What field do you want to update?");
                    System.out.println("Press c for city");
                    System.out.println("Press p for phone");

                    String ch =br.readLine();
                    if(ch.equals("c")){
                        System.out.println("Enter the new city");
                        String city = br.readLine();

                        boolean ans = StudentDao.updateStudentCity(sid,city);
                        if(ans){
                            System.out.println("Student with id ="+ sid +" updated");
                        }
                        else{
                            System.out.println("Something went wrong , Please try again.........");
                        }


                    }
                    else if(ch.equals("p")){
                        System.out.println("Enter the new phone");
                        String phone = br.readLine();
                        boolean ans = StudentDao.updateStudentPhone(sid,phone);
                        if(ans){
                            System.out.println("Student with id ="+ sid +" updated");
                        }
                        else{
                            System.out.println("Something went wrong , Please try again.........");
                        }
                    }
                    else{
                        break;
                    }

                }



            }
            else if(choice==5 || choice==Integer.parseInt("")){
                break;
            }
            else {

            }
        }
        System.out.println("Thank you for using the service.....");
    }
}
