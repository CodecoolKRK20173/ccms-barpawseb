package users;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User{
    protected static List<Student> allStudents;
    protected Employee(String name){
        super(name);
    }

    protected Employee (String name, String password, int id, ArrayList<Student> allStudents){
        super(name, password, id);
        this.allStudents = allStudents;
    }

    public void setStudentsList(ArrayList<Student> students){
        allStudents = students;
    }

    public List<Student> getAllStudents(){
        return allStudents;
    }
}