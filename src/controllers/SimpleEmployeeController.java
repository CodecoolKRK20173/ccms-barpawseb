package controllers;

import java.util.*;
import database.*;
import users.*;
import view.*;

public class SimpleEmployeeController {

    private Employee employee;
    private View view;
    private DataReglamentator database;
    private final String[] mamu = {"Show List of Mentors",
                                   "Show List Of Students", "Change Password", "Exit"};
    
    private static Scanner in = new Scanner(System.in);

    public SimpleEmployeeController(DataReglamentator database, String email){
        view = new View();
        this.database = database;
        employee = this.database.getEmployeeByEmail(email);
    }
    public void showManu(){
        view.showManu(this.mamu);
    }

    public void setPassword(){
        System.out.println("Your current password: " + employee.getPassword());
        System.out.print("Enter new password: ");
        String newPassword = in.nextLine();
        employee.setPassword(newPassword);
        database.updateDataManager();
    }

    public void showStudents(){
        view.showStudentList(database.getStudentsList());
    }

    public void showMentors(){
        view.showEmploeeList(database.extractMentorsList());
    }

}
