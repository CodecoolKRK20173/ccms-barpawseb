import database.LoaderSaver;
import java.io.IOException;
import java.util.Scanner;

class CcMS {
    CcMS() throws IOException {
        LoaderSaver users = new LoaderSaver();
        users.loadUsersList("src/database/users.csv");
        users.displayAllUsers();
        login();
        users.userInfo("1,b@c.d,A,B,m");
    }

    public void login() {
        Scanner scan = new Scanner (System.in);
        System.out.print("Please provide e-mail: ");
        String email = scan.nextLine();
        System.out.print("Please provide password: ");
        String passwd = scan.nextLine();
    }
}
