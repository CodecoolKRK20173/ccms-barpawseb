package controllers;
import users.*;
import view.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

import database.*;

public class SupervisorController {

    private User supervisor;
    private View view;
    private DataReglamentator database;
    private final String[] mamu = {"Add Mentor", "Remove Mentor",
                                   "View Mentor's Data", "Show List of Mentors",
                                   "Show List Of Students", "Change emploee's salary", "Exit"};
    
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
        database.updateDataManager();
    }
    public void removeMentor(){
        System.out.print("Enter mentor's email You want to remove: ");
        String email = in.nextLine();
        if (database.removeEmployeeByEmail(email))
            System.out.println("Mentor has been removed.");
        else
            System.out.println("There's no such mentor.");
        database.updateDataManager();
    }
    public void showMentorsData(){
        System.out.print("Enter mentors's email for editing his/her data: ");
        String email = in.nextLine();
        try {
            Employee employee = database.getEmployeeByEmail(email);
            view.showEmploeeData(employee);
        }
        catch (NoSuchElementException e) {
            System.out.println("There is no such mentor.");
        }
    }
    public void showMentors(){
        view.showEmploeeList(database.extractMentorsList());
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
        database.updateDataManager();
    }

    public void setPassword(){
        System.out.println("Your current password: " + supervisor.getPassword());
        System.out.print("Enter new password: ");
        String newPassword = in.nextLine();
        supervisor.setPassword(newPassword);
        database.updateDataManager();
    }

    public void showManu(){
        view.showManu(this.mamu);
    }
}
