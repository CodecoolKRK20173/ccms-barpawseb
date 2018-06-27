package database;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import users.Employee;
import users.Student;

public class DataReglamentator{
    Iterable<String[]> dataMenager;
    Collection<User> allUsers;

    public DataReglamentator() throws IOException{
        dataMenager = new DataManager();
        allUsers = new ArrayList<>();
    }

    public List<Student> getStudentsList(){
        List<Student> students = new ArrayList<>();
        for(String[] line: dataMenager){
            if(line[4].equals("s"))
                students.add(new Student(line[2], line[0], line[3], Integer.parseInt(line[5])));
        }
        return students; 
    }

    public List<Employee> getEmoloyees(){ 
        List<Employee> emoloyees = new ArrayList<>();
        for(String[] line: dataMenager){
            if(line[4].equals("e") || line[4].equals("m"))
                emoloyees.add(new Employee(line[2], line[0], line[3], Double.parseDouble(line[5])));
        }
        return emoloyees;
    }

    public void updateDataMenager(List<User> allUsers){
        for
    }

    public static void main(String[] args)throws IOException {
        DataReglamentator test = new DataReglamentator();
        System.out.println(test.getStudentsList());
        System.out.println(test.getEmoloyees());
    }
}

