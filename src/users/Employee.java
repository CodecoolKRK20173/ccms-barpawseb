package users;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User{
    double salary;

    public Employee(String name, String email){
        super(name, email);
        salary = 500;
    }

    public Employee (String name, String email, String password, double salary){
        super(name, password, email);
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double advance){
        salary = advance;
    }
    
    public String toString(){
        return String.format("\n%s \t\tSalary: %f",super.toString(), salary);
    }
    
}