package controllers;
import java.util.Scanner;

import users.*;
import view.*;

public class MentorController {
    
    private Mentor mentor;
    private View view;
    private final String[] namu = {"Show all Students", "Add Student",
                                   "Remove Student", "Edit Student's Data", 
                                   "Check Attendance Of Students",
                                   "Add Assignment", "Grade Assignments",
                                   "Change Password"};

    private static Scanner in = new Scanner(System.in);

    public MentorController(String name, String email, String password, double salary){
        mentor = new Mentor(name, email, password, salary);
        view = new View();
    }
    public void setPassword(){
        System.out.println("Your current password: " + mentor.getPassword());
        System.out.println("Enter new password: ");
        String newPassword = in.nextLine();
        mentor.setPassword(newPassword);
    }
    

}
