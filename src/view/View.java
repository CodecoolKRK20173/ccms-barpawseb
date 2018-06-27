package view;
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
}
