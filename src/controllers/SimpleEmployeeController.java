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
                                   "Show List Of Students"};
    
    private static Scanner in = new Scanner(System.in);

    public SimpleEmployeeController(DataReglamentator database, String email){
        view = new View();
        this.database = database;
        employee = this.database.getEmployeeByEmail(email);
    }
    public void showStudents(){
        view.showStudentList(database.getStudentsList());
    }
}
