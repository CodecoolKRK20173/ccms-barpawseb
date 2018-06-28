package controllers;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import database.*;
import users.*;
import view.*;

public class StudentController{
    
    private Student student;
    private View view;
    private DataReglamentator database;
    private final String[] manu = {"Submit Assignment", "View Grades", "Change Password", "Show My Profile", "Exit"};

    private static Scanner in = new Scanner(System.in);

    public StudentController(DataReglamentator database, String email){
        view = new View();
        this.database = database;
        student = database.getStudentByEmail(email);
    }
    public void showGrades(){
        view.showGrades(student.getGrades());
    }

    public void setPassword(){
        System.out.println("Your current password: " + student.getPassword());
        System.out.print("Enter new password: ");
        String newPassword = in.nextLine();
        student.setPassword(newPassword);
        database.updateDataManager();
    }

    public void showData() {
        view.showStudentData(this.student);
    }

    public void showManu(){
        view.showManu(this.manu);
    }

}
