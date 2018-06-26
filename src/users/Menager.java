package users;

import java.util.List;
import java.util.ArrayList;

 public class Menager extends User {
     private List<Employee> allEmployees = new ArrayList<>();
     
    
   /* public Jerzy (String name){
        super(name);
    }*/

    protected Menager(String name, String password, int id, List<Employee> allEmployees){
        super(name, password, id);
        this.allEmployees = allEmployees;
    }

    protected void addEmployee(String name){
        allEmployees.add(new Employee(name));
    }

    protected void removeEmployee(int id){
        /*for (Mentor mentor: allMentors){
            if(Mentor.getId()==id)
                allMentors.remove(Mentor);*/
        allEmployees.removeIf(emp -> emp.getId() == id);
    }



 }