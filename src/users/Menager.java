package users;

import java.util.List;
import java.util.ArrayList;

 public class Menager extends User {

    public Menager (String name, String email){
        super(name, email);
    }
    
    protected Menager(String name, String email, String password){
        super(name, password, email);
    }

    /*protected void addEmployee(String name){
        allEmployees.add(new Employee(name));
    }

    protected void removeEmployee(String email){
        allEmployees.removeIf(emp -> emp.getEmail() == id);
    }*/
 }