import database.DataManager;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class CcMS {
    private DataManager users;

    CcMS() throws IOException {
        users = new DataManager();
        users.loadUsersList("src/database/users.csv");

//        displayAllUsers();
//        displayAllStudents();
//        displayAllMentors();
        login();
    }

    public static void login() {
        Scanner scan = new Scanner (System.in);
        System.out.print("Please provide e-mail: ");
        String email = scan.nextLine();
        System.out.print("Please provide password: ");
        String passwd = scan.nextLine();

    }

    public boolean doesUserExist(String email) {
        for (String user : users){
            String[] parts = user.split(",");
            if (parts[0].equals(email))
                return true;
        }
        return false;
    }


    public void displayAllUsers() {
        for (String user : users) {
            System.out.println(user);
        }
    }

    public void displayAllStudents() {
        for (String user : users) {
            String[] parts = user.split(",");
            if (parts[4].equals("s"))
                System.out.println(user);
        }
    }

    public void displayAllMentors() {
        for (String user : users) {
            String[] parts = user.split(",");
            if (parts[4].equals("m"))
                System.out.println(user);
        }
    }
}
