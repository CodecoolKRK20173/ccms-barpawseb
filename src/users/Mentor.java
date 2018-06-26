package users;
import java.util.List;
import java.util.ArrayList;
 public class Mentor extends Employee{

    protected Mentor(String name){
        super(name);
        
    }

    protected Mentor(String name, String password, int id, ArrayList<Student> allStudents){
        super(name, password, id, allStudents);
    }

    public void addStudent(String name){
        allStudents.add(new Student(name));
    }

    public void removeStudent(int id){
        allStudents.removeIf(s -> s.getId() == id);
    }
 }