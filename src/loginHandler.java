import database.DataManager;
import java.io.IOException;
import java.util.Scanner;

class loginHandler {
    private DataManager dataManager;
    private static String[] loggingInUserDetails;

    loginHandler() throws IOException {
        dataManager = new DataManager();
        isLoggedIn();
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

    private boolean isLoggedIn() {
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
                loggingInUserDetails = user;
                return true;
            }
        }
        System.out.println("There is no such user. :(");
        return false;
    }

    private boolean isPasswordCorrect(String passFromUser) {
        String passFromDatabase = loggingInUserDetails[3];
        if ((passFromUser.equals(passFromDatabase))) return true;
        else {
            System.out.println("Wrong password.");
            return false;
        }
    }
}
