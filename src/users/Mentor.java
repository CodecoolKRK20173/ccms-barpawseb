package users;

 public class Mentor extends Employee{

    public Mentor(String name, String email){
        super(name, email);
    }

    public Mentor(String name, String email, String password, double salary){
        super(name, email, password, salary);
    }
/*
    public void addStudent(String name){
        allStudents.add(new Student(name));
    }

    public void removeStudent(String email ){
        allStudents.removeIf(s -> s.getEmail() == email);
    }*/

 }