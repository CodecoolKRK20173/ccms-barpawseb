import application.Application;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            Application application = new Application("src/data/users.csv","src/data/assignments.csv");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
