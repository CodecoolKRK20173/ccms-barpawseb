package users;

import java.util.List;
import java.util.ArrayList;

 public class Supervisor extends User {

    public Supervisor (String name, String email){
        super(name, email);
    }
    
    protected Supervisor (String name, String email, String password){
        super(name, email, password);
    }

    /*protected void addEmployee(String name){
        allEmployees.add(new Employee(name));
    }

    protected void removeEmployee(String email){
        allEmployees.removeIf(emp -> emp.getEmail() == id);
    }*/
 }