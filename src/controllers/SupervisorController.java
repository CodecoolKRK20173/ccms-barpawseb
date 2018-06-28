package controllers;
import users.*;
import view.*;

import java.util.Scanner;

import database.*;

public class SupervisorController {

    private User supervisor;
    private View view;
    private DataReglamentator database;
    private final String[] mamu = {"Add Mentor", "Remove Mentor",
                                   "Edit Mentor's Data", "Show List of Mentors",
                                   "Show List Of Students", "Change emploee's salary"};
    
    private static Scanner in = new Scanner(System.in);

    public SupervisorController(DataReglamentator database, String email){
        view = new View();
        this.database = database;
        supervisor = this.database.getUserByEmail(email);
    }
    public void addMentor(){
        System.out.print("Enter mentors's name: ");
        String name = in.nextLine();
        System.out.print("Enter mentors's email: ");
        String email = in.nextLine();;
        database.addMentor(name, email);
    }
    public void removeMentor(){
        System.out.print("Enter mentor's email You want to remove: ");
        String email = in.nextLine();
        database.removeEmployeeByEmail(email);
    }
    public void showMentorsData(){
        System.out.print("Enter mentors's email for editing student's data: ");
        String email = in.nextLine();
        Employee employee = database.getEmployeeByEmail(email);
        view.showEmploeeData(employee);
    }
    public void showMentors(){

    }
    public void showStudents(){
        view.showStudentList(database.getStudentsList());
    }
    public void changeEmploeeSalary(){
        System.out.print("Choose emploee by email: ");
        String email = in.nextLine();
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(in.nextLine());
        database.getEmployeeByEmail(email).setSalary(salary);
    }
    public void showManu(){
        view.showManu(this.mamu);
    }
}
