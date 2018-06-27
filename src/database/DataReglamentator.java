package database;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.IOException;
import users.*;

public class DataReglamentator{
    DataManager dataManager;
    List<Student> students =  new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    Collection <User> allUsers;

    public DataReglamentator() throws IOException{
        dataManager = new DataManager();
        createStudentsList();
        createEmployeesList();
        allUsers.addAll(students);
        allUsers.addAll(employees);
    }


    private void createStudentsList(){
        for(String[] line: dataManager){
            if(line[3].equals("s"))
                students.add(new Student(line[1], line[0], line[2], Integer.parseInt(line[4])));
        }
    }

    private void createEmployeesList(){ 
        for(String[] line: dataManager){
            if(line[3].equals("e") || line[3].equals("m"))
                employees.add(new Employee(line[1], line[0], line[2], Double.parseDouble(line[4])));
        }
    }
 
    public User getUserByName(String name)throws NoSuchElementException{
        for( User user: allUsers){
            if (user.getName().equals(name)) return user;
        }
        throw new NoSuchElementException();
    }

    public User getUserByEmail(String email) throws NoSuchElementException{
        for (User user: allUsers){
            if (user.getEmail().equals(email)) return user;
        }
        throw new NoSuchElementException();
    }

    public Student getStudentByName(String name)throws NoSuchElementException{
        for (Student student: students){
            if (student.getName().equals(name)) return student;
        }
        throw new NoSuchElementException();
    }

    public Student getStudentByEmail(String email) throws NoSuchElementException{
        for (Student student: students){
            if (student.getEmail().equals(email)) return student;
        }
        throw new NoSuchElementException();
    }
    

    public Employee getEmployeeByName(String name){
        for (Employee employee: employees){
            if (employee.getName().equals(name)) return employee;
        }
        throw new NoSuchElementException();
    }

    public Employee getEmployeeByEmail(String email){
        for (Employee employee: employees){
            if (employee.getEmail().equals(email)) return employee;
        }
        throw new NoSuchElementException();
    }

    public List<Student> getStudentsList(){
        return students;
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void addStudent(String name, String email){
        students.add(new Student(name,email));
    }

    public void removeStudentByEmail(String email ){
        students.removeIf(s -> s.getEmail().equals(email));
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public void addMentor(String name, String email){
        employees.add(new Mentor(name, email));
    }

    public void addSimpleEmployee(String name, String email){
        employees.add(new Employee(name, email));
    }

    public void removeEmployeeByEmail(String email){
        employees.removeIf(emp -> emp.getEmail().equals(email));
    }
    
    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public void addEmployee(String name, String email){
        employees.add(new Employee(name, email));
    }

   
    public void updateDataManager(){
        List <String[]> lines = transformUsersListToExportLines();
        dataManager.setUsersLines(lines);
    }

    private List<String[]> transformUsersListToExportLines(){
        List<String[]> usersLines = new ArrayList<>();
        String status;
        String salary;
        String grades;
        for (User user: allUsers){
            if(user.getStatus().equals("Student")){
                Student student = (Student)user;
                status = "s";
                salary = "null";
                grades = String.valueOf(student.getGradesSum());
            }
            if (user.getStatus().equals("Mentor")){
                Mentor mentor = (Mentor) user;
                status = "m";
                salary = String.valueOf(mentor.getSalary());
                grades = "null";

            }
            if(user.getStatus().equals("Employee")){
                Employee employee = (Employee)user;
                status = "e";
                salary = String.valueOf(employee.getSalary());
                grades = "null";
            }
            else{
                Supervisor supervisor = (Supervisor) user;
                status = "b";
                grades = "null";
                salary = "null";
            }
            String[] line = {user.getEmail(),user.getName(),user.getPassword(),status,grades,salary};
            usersLines.add(line);
        }
        return usersLines;        
    }
           
  

    public static void main(String[] args)throws IOException {
        DataReglamentator test = new DataReglamentator();
        System.out.println(test.getStudentsList());
        System.out.println(test.getEmployees());
    }
}

