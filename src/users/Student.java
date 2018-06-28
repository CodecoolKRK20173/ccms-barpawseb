package users;

import java.util.HashMap;
import java.util.Map;


public class Student extends User{
    private Map<String, Double> grades = new HashMap<>(); //String: title
    private double gradesSum;
    private int absence;

    public Student(String name, String email){
        super(name, email);
        gradesSum = 0.0;
        absence = 0;
    }

    public Student(String name, String email, String password, int absence){
        super(name, email, password);
        this.gradesSum = grades.values().stream().mapToDouble(Number::doubleValue).sum();
        this.absence = absence;
    }

    public double getGradesSum(){
        return gradesSum;
    }

    public Map<String,Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<String,Double> grades){
        this.grades = grades;
    }

    public void addToGrades(String assignment, double points){
        grades.putIfAbsent(assignment, points);
    }

    public void changeGrade(String assignment, double newPoints){
        grades.put(assignment, newPoints);
    }

    public int getAbsence(){
        return absence;
    }

    public void incrementAbsence(){
        absence++;
    }

    public String toString(){
        return String.format("\n%s \t\tAbsence: %d",super.toString(), absence);

    }
}