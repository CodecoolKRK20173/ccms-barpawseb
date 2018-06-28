package controllers;
import java.util.Scanner;
import java.util.List;
import database.*;
import users.*;
import view.*;

public class MentorController {
    
    private Mentor mentor;
    private View view;
    private DataReglamentator database;
    private final String[] namu = {"Show all Students", "Add Student",
                                   "Remove Student", "View Student's Data",
                                   "Check Attendance Of Students",
                                   "Add Assignment", "Grade Assignments",
                                   "Change Password", "Exit"};

    private static Scanner in = new Scanner(System.in);

    public MentorController(DataReglamentator database, String email){
        view = new View();
        this.database = database;
        mentor = (Mentor) this.database.getEmployeeByEmail(email);
    }
    public void setPassword(){
        System.out.println("Your current password: " + mentor.getPassword());
        System.out.print("Enter new password: ");
        String newPassword = in.nextLine();
        mentor.setPassword(newPassword);
        database.updateDataManager();
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
        String email = in.nextLine();;
        database.addStudent(name, email);
        database.updateDataManager();
    }
    public void removeStudent(){
        System.out.print("Enter student's email You want to remove: ");
        String email = in.nextLine();
        if (database.removeStudentByEmail(email))
            System.out.println("Student has been removed.");
        else
            System.out.println("There's no such student.");
        database.updateDataManager();
    }
    public void showStudentsData(){
        System.out.print("Enter student's email for editing student's data: ");
        String email = in.nextLine();
        Student student = database.getStudentByEmail(email);
        view.showStudentData(student);
    }

    public void checkAttendence() {
        List<Student> studentsList = getStudentsList();
        for (Student student : studentsList) {
            view.showStudentData(student);
            System.out.print("Is this student present? (Y/N): ");
            if (in.nextLine().toLowerCase().equals("n"))
                student.incrementAbsence();
        }
        database.updateDataManager();
    }
    public void gradeStudent(){
        System.out.print("Enter student's email You want to grade: ");
        String email = in.nextLine();
        Student student = database.getStudentByEmail(email);
        view.showStudentData(student);
        view.showGrades(database.getStudentByEmail(email).getGrades());
        System.out.print("Choose assignment You want to grade: ");
        String assignment = in.nextLine();
        System.out.println("Enter Your grade value: ");
        double grade = Double.parseDouble(in.nextLine());
        student.getGrades().put(assignment, grade);
        database.updateDataManager();
    }



}
