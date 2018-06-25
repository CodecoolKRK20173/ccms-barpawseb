import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import things.*;

package users;

public class Student extends User{
    protected float grades;
    public List<Assigment> myAssigments;

    protected Student(String name){
        super(name);
        myAssigments = new ArrayList<>();
    }

    private void addToMyAssigments(Assigment assigment){
        myAssigments.add(assigment);
    }
}