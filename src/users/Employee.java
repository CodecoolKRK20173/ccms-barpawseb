package users;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee extends User{
    protected static List<Student> allStudents;
    protected Employee(String name){
        super(name);   
    }
    protected List<Student> getAllStudents(){
        return allStudents;
    }
}