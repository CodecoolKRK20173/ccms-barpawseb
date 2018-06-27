package view;
import java.util.List;

import users.*;

public class View {

    public void showManu(String [] manu){
        for(int i = 0; i < manu.length; i++){
            System.out.println("" + i+1 + ". " + manu[i]);
        }
    }
    public void showUserData(User user){
        System.out.println(user.toString());
    }
    public void showStudentList(List<Student> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println("" + i+1 + ". " + list.get(i).toString());
        }
    }
}
