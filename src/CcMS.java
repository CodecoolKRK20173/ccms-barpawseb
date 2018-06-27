import database.DataManager;
import java.io.IOException;
import java.util.Scanner;
import java.util.Iterator;

class CcMS {
    private DataManager dataManager;
    private Iterator<String[]> usersIterator;
    private static String emailFromUser;
    private static String passFromUser;
    private static String[] userDetails;

    CcMS() throws IOException {
        dataManager = new DataManager();
        getLoginData();
        isLoggedIn();
//        displayAllUsers();
//        displayAllStudents();
//        displayAllMentors();
    }

    private static void getLoginData() {
        Scanner scan = new Scanner (System.in);
        System.out.print("Please provide e-mail: ");
        emailFromUser = scan.nextLine();
        System.out.print("Please provide password: ");
        passFromUser = scan.nextLine();
    }

    private boolean isLoggedIn() {
        if (isUserInDatabase(emailFromUser)) {
            if (isPasswordCorrect(passFromUser)) {
                System.out.println("Good! Yo're in.");
                return true;
            }
        }
        return false;
    }

    private boolean isUserInDatabase(String email) {
        usersIterator = dataManager.iterator();
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

    public void displayAllUsers() {
        usersIterator = dataManager.iterator();
        while(usersIterator.hasNext()) {
            String[] userInfo = usersIterator.next();
            System.out.println(userInfo[0] + " " + userInfo[1] + " " + userInfo[2]);
        }
    }

    public void displayAllStudents() {
        usersIterator = dataManager.iterator();
        while(usersIterator.hasNext()) {
            String[] userInfo = usersIterator.next();
            String userStatus = userInfo[4];
            if (userStatus.equals("s"))
                System.out.println(userInfo[0] + " " + userInfo[1] + " " + userInfo[2]);
        }
    }

    public void displayAllMentors() {
        usersIterator = dataManager.iterator();
        while(usersIterator.hasNext()) {
            String[] userInfo = usersIterator.next();
            String userStatus = userInfo[4];
            if (userStatus.equals("m"))
                System.out.println(userInfo[0] + " " + userInfo[1] + " " + userInfo[2]);
        }
    }
}
