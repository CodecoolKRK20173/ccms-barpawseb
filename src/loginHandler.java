import database.DataManager;
import java.io.IOException;
import java.util.Scanner;
import java.util.Iterator;

class loginHandler {
    private DataManager dataManager;
    private static String[] userDetails;

    loginHandler() throws IOException {
        dataManager = new DataManager();
        isLoggedIn();
    }

    private static String getEmailFromUser() {
        Scanner scan = new Scanner (System.in);
        System.out.print("Please provide e-mail: ");
        String emailFromUser = scan.nextLine();
        return emailFromUser;
    }

    private static String getPasswordFromUser() {
        Scanner scan = new Scanner (System.in);
        System.out.print("Please provide password: ");
        String passFromUser = scan.nextLine();
        return passFromUser;
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
        Iterator<String[]> usersIterator = dataManager.iterator();
        while (usersIterator.hasNext()) {
            userDetails = usersIterator.next();
            String emailFromDatabase = userDetails[0];
            if (emailFromDatabase.equals(email)) {
                return true;
            }
        }
        System.out.println("There is no such user. :(");
        return false;
    }

    private boolean isPasswordCorrect(String passFromUser) {
        String passFromDatabase = userDetails[3];
        if ((passFromUser.equals(passFromDatabase))) return true;
        else {
            System.out.println("Wrong password.");
            return false;
        }
    }
}
