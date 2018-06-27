package controllers;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import database.*;
import users.*;
import view.*;

public class MentorController {
    
    private Mentor mentor;
    private View view;
    private DataReglamentator database;
    private final String[] namu = {"Show all Students", "Add Student",
                                   "Remove Student", "Edit Student's Data", 
                                   "Check Attendance Of Students",
                                   "Add Assignment", "Grade Assignments",
                                   "Change Password"};

    private static Scanner in = new Scanner(System.in);

    public MentorController(String name, String email, String password, double salary){
        mentor = new Mentor(name, email, password, salary);
        view = new View();
        try{
            database = new DataReglamentator();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setPassword(){
        System.out.println("Your current password: " + mentor.getPassword());
        System.out.print("Enter new password: ");
        String newPassword = in.nextLine();
        mentor.setPassword(newPassword);
    }
    public List<Student> getStudentsList(){
        return database.getStudentsList();
    }
    public void showStudents(){
        view.showStudentList(getStudentsList());
    }
    public void showManu(){
        view.showManu(this.namu);
    }
    public void addStudent(){
        System.out.print("Enter student's name: ");
        String name = in.nextLine();
        System.out.print("Enter student's email: ");
        String email = in.nextLine();
        Student newStudent = new Student(name, email);
        // not done yet waiting for DataReglamentator method
    }
    public void removeStudent(){
        System.out.print("Enter student's email You want to remove: ");
        String email = in.nextLine();
        // not done yet waiting for DataReglamentator method
    }
    public void showStudentsData(){
        System.out.print("Enter student's email for editing student's data: ");
        String email = in.nextLine();
        // not done yet waiting for DataReglamentator method
        //view.showUserData(user);
    }

    

}
