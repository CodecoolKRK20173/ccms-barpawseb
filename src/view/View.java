package view;
import java.util.List;
import java.util.Map;

import users.*;

public class View {

    public void showManu(String [] manu){
        for(int i = 0; i < manu.length; i++){
            System.out.println("" + i+1 + ". " + manu[i]);
        }
    }
    public void showEmploeeData(Employee employee){
        System.out.println(employee.toString());
    }
    public void showStudentData(Student student){
        System.out.println(student.toString());
    }
    public void showStudentList(List<Student> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println("" + i+1 + ". " + list.get(i).toString());
        }
    }
    public void showGrades(Map<String, Double> map){
        for(String key: map.keySet()){
            System.out.println("Assignment: " + key + " Grade: " + map.get(key));
        }
    }
}
