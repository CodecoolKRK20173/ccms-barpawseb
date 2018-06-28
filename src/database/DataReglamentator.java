package database;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Arrays;

import java.io.IOException;
import users.*;

public class DataReglamentator{
    DataManager dataManager;
    DataManager usersAssignmentDataManager;
    List<Supervisor> supervisors = new ArrayList<>();
    List<Student> students =  new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    List <User> allUsers = new ArrayList<>();

    public DataReglamentator(String filePath, String filePath2) throws IOException{
        dataManager = new DataManager(filePath);
        usersAssignmentDataManager = new DataManager(filePath2);
        createListsOfAllTypeOfUser();
        updateAllUssersList();
    }

    private void updateAllUssersList(){
        allUsers.clear();
        allUsers.addAll(supervisors);
        allUsers.addAll(students);
        allUsers.addAll(employees);
    }

    private void createListsOfAllTypeOfUser(){
        for(String[] line: dataManager){
            String email = line[0];
            String name = line[1];
            String password = line[2];
            String status = line[3];
            String absence = line[4];
            String salary = line[5];
            if(status.equals("Supervisor"))
                supervisors.add(new Supervisor(name, email, password));
            else if(status.equals("Student"))
                students.add(new Student(name, email, password, Integer.parseInt(absence)));
            else if (status.equals("Mentor"))
                employees.add(new Mentor(name, email, password, Double.parseDouble(salary)));
            else employees.add(new Employee(name, email, password, Double.parseDouble(salary)));
        }
        createGrades();
    }

    private void createGrades(){
        for(String[]line: usersAssignmentDataManager){
            String studentEmail = line[0];
            Map<String, Double> studentGrades = createAssigmentsMap(line);
            getStudentByEmail(studentEmail).setGrades(studentGrades);
        }
    }

    private Map<String, Double> createAssigmentsMap(String[]line){
        Map<String, Double> studentGrades = new HashMap<>();
        for(int i=1; i<line.length-1; i+=2){
            String assignment = line[i];
            double points = Double.parseDouble(line[i+1]);
            studentGrades.put(assignment,points);
        }
        return studentGrades;

    }
    
    public Collection<User> getUsersList(){
        return allUsers;
    }
    
    public List<Student> getStudentsList(){
        return students;
    }

    public List<Employee> getEmployeesList(){
        return employees;
    }

    public List<Employee> extractMentorsList(){
        List<Employee> mentorsPicked = new ArrayList<>();
        for(Employee employee: employees){
            if(employee.getStatus().equals("Mentor"))
                mentorsPicked.add(employee);
        }
        return mentorsPicked;
    }

 
    //usefull only during login
    public User getUserByName(String name)throws NoSuchElementException{
        for( User user: allUsers){
            if (user.getName().equals(name)) return user;
        }
        throw new NoSuchElementException();
    }

    //usefull only during login
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

    public void addStudent(String name, String email){
        students.add(new Student(name,email));
        updateAllUssersList();
    }

    public boolean removeStudentByEmail(String email ){
        if (students.removeIf(s -> s.getEmail().equals(email))) {
            updateAllUssersList();
            return true;
        }
        else
            return false;
    }

    public void removeStudent(Student student){
        students.remove(student);
        updateAllUssersList();
    }

    
    public void addMentor(String name, String email){
        employees.add(new Mentor(name, email));
        updateAllUssersList();
    }

    public void addSimpleEmployee(String name, String email){
        employees.add(new Employee(name, email));
        updateAllUssersList();
    }

    public boolean removeEmployeeByEmail(String email){
        if (employees.removeIf(emp -> emp.getEmail().equals(email))) {
            updateAllUssersList();
            return true;
        }
        else
            return false;
    }
    
    public void removeEmployee(Employee employee){
        employees.remove(employee);
        updateAllUssersList();
    }

   
    public void updateDataManager(){
        List <String[]> lines = transformUsersListToExportLines();
        dataManager.setUsersLines(lines);
        //for(String[] line:lines)
          //  System.out.println(Arrays.toString(line));
    }

    private List<String[]> transformUsersListToExportLines(){
        updateAllUssersList();
        List<String[]> usersLines = new ArrayList<>();
        String salary;
        String absence;
        for (User user: allUsers){
            if(user.getStatus().equals("Student")){
                Student student = (Student)user;
                salary = "null";
                absence = String.valueOf(student.getAbsence());
            }
            else if (user.getStatus().equals("Supervisor")){
                absence = "null";
                salary = "null";
            }
            else{
            Employee employee = (Employee)user;
                salary = String.valueOf(employee.getSalary());
                absence = "null";
            }
            String[] line = {user.getEmail(),user.getName(),user.getPassword(),user.getStatus(),absence,salary};
            usersLines.add(line);
        }
        return usersLines;        
    }

    public static void main(String[] args)throws IOException {

        DataReglamentator test = new DataReglamentator("src/data/users.csv","src/data/assignments.csv");
        for (Student stu : test.students) {
            stu.getGrades().forEach((k,v) -> System.out.println("key: "+k+" value:"+v));
            
        }
        
        //test.updateDataManager();
       /*
        System.out.println(test.getStudentsList());
        System.out.println(test.getEmployeesList());
        System.out.println(test.getUsersList());
        System.out.println(" \n* * * \n");

        test.addStudent("piotr", "email");
        System.out.println(test.getStudentsList());
        System.out.println(" \n* * * \n");*/
        //System.out.println(test.getUsersList());
    }
}

