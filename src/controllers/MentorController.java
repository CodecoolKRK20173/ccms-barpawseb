package controllers;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.List;
import database.*;
import users.*;
import view.*;

public class MentorController {
    
    private Mentor mentor;
    private View view;
    private DataReglamentator dataReglamentator;
    private final String[] namu = {"Show all Students", "Add Student",
                                   "Remove Student", "View Student's Data",
                                   "Check Attendance Of Students",
                                   "Add Assignment", "Grade Assignments",
                                   "Change Password", "Exit"};

    private static Scanner in = new Scanner(System.in);

    public MentorController(DataReglamentator database, String email){
        view = new View();
        this.dataReglamentator = database;
        mentor = (Mentor) this.dataReglamentator.getEmployeeByEmail(email);
    }

    public void setPassword(){
        System.out.println("Your current password: " + mentor.getPassword());
        System.out.print("Enter new password: ");
        String newPassword = in.nextLine();
        mentor.setPassword(newPassword);
        dataReglamentator.updateDataManager();
    }

    public List<Student> getStudentsList(){
        return dataReglamentator.getStudentsList();
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
        dataReglamentator.addStudent(name, email);
        dataReglamentator.updateDataManager();
    }

    public void removeStudent(){
        System.out.print("Enter student's email You want to remove: ");
        String email = in.nextLine();
        if (dataReglamentator.removeStudentByEmail(email))
            System.out.println("Student has been removed.");
        else
            System.out.println("There's no such student.");
        dataReglamentator.updateDataManager();
    }

    public void showStudentsData(){
        System.out.print("Enter student's email for editing student's data: ");
        String email = in.nextLine();
        Student student = dataReglamentator.getStudentByEmail(email);
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
        dataReglamentator.updateDataManager();
    }

    public void gradeStudent(){
        boolean isEmailInDatabase = false;
        Student student = null;
        while (!isEmailInDatabase) {
            try {
                System.out.print("Enter student's email you want to grade: ");
                String email = in.nextLine();
                student = dataReglamentator.getStudentByEmail(email);
                view.showStudentData(student);
                view.showGrades(dataReglamentator.getStudentByEmail(email).getGrades());
                isEmailInDatabase = true;
            }
            catch (NoSuchElementException e) {
                System.out.println("There is no such e-mail.");
            }
        }

        System.out.print("Choose assignment You want to grade: ");
        String assignment = in.nextLine();
        System.out.println("Enter Your grade value: ");
        double grade = Double.parseDouble(in.nextLine());
        student.getGrades().put(assignment, grade);
        dataReglamentator.updateDataManager();
    }

    public void addAssignment() {
        System.out.print("Enter assignment you want to add: ");
        String assignment = in.nextLine();
        double initialGrade = 0.0;
        List<Student> studentsList = dataReglamentator.getStudentsList();
        for (Student student : studentsList) {
            student.getGrades().put(assignment, initialGrade);
        }
        dataReglamentator.updateDataManager();
    }
}
