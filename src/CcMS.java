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
        usersIterator = dataManager.iterator();
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
                System.out.println("GOOD! You're in!");
                return true;
            }
            else
                System.out.println("Wrong password.");
        }
        else {
            System.out.println("No such user. :(");
        }
        return false;
    }

    private boolean isUserInDatabase(String email) {
        while(usersIterator.hasNext()) {
                userDetails = usersIterator.next();
                String emailFromDatabase = userDetails[0];
            if (emailFromDatabase.equals(email)) {
                return true;
            }

        }
        return false;
    }

    private boolean isPasswordCorrect(String password) {
        String passwordFromDatabase = userDetails[3];
        return (password.equals(passwordFromDatabase));
    }


    public void displayAllUsers() {
        while(usersIterator.hasNext()) {
            System.out.println(usersIterator.next());
        }
    }

//    public void displayAllStudents() {
//        for (String user : users) {
//            String[] parts = user.split(",");
//            if (parts[4].equals("s"))
//                System.out.println(user);
//        }
//    }

//    public void displayAllMentors() {
//        for (String user : users) {
//            String[] parts = user.split(",");
//            if (parts[4].equals("m"))
//                System.out.println(user);
//        }
//    }
}
