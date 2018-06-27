import controllers.StudentController;
import database.DataManager;
import java.io.IOException;
import java.util.Scanner;

class LoginHandler {
    private DataManager dataManager;
    private String[] loggedInUserDetails;

    LoginHandler() throws IOException {
        dataManager = new DataManager();
    }

    private static String getEmailFromUser() {
        Scanner scan = new Scanner (System.in);
        System.out.print("Please provide e-mail: ");
        return scan.nextLine();
    }

    private static String getPasswordFromUser() {
        Scanner scan = new Scanner (System.in);
        System.out.print("Please provide password: ");
        return scan.nextLine();
    }

    boolean isLoggedIn() {
        if (isUserInDatabase(getEmailFromUser())) {
            if (isPasswordCorrect(getPasswordFromUser())) {
                System.out.println("Good! Yo're in.");
                return true;
            }
        }
        return false;
    }

    private boolean isUserInDatabase(String email) {
        for (String[] user : dataManager) {
            String emailFromDatabase = user[0];
            if (emailFromDatabase.equals(email)) {
                loggedInUserDetails = user;
                return true;
            }
        }
        System.out.println("There is no such user. :(");
        return false;
    }

    private boolean isPasswordCorrect(String passFromUser) {
        String passFromDatabase = loggedInUserDetails[3];
        if ((passFromUser.equals(passFromDatabase))) return true;
        else {
            System.out.println("Wrong password.");
            return false;
        }
    }

    public String[] getloggedInUserDetails() {
        return loggedInUserDetails;
    }
}
