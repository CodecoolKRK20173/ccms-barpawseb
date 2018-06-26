package users;

 public class Mentor extends Employee{

    protected Mentor(String name){
        super(name);
    }

    protected Mentor(String name, String password, String id, List<Student> allStudents){
        super(name, password, id, allStudents);
    }

    public void addStudent(String name){
        allStudents.add(new Student(name));
    }
 }