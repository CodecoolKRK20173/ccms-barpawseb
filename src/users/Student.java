package users;

import java.util.ArrayList;
import java.util.List;

import things.*;

public class Student extends User{
    protected float grades;
    public List<Assigment> myAssigments;

    protected Student(String name){
        super(name);
        myAssigments = new ArrayList<>(); //as far ArrayList, later maybe set, 
    }

    protected Student(String name, String password, int id, List<Assigment> myAssigments){
        super(name, password, id);
        this.myAssigments = myAssigments;
    }

    private void addToMyAssigments(Assigment assigment){
        myAssigments.add(assigment);
    }
}