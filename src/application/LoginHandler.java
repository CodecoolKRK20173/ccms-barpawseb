package application;

import database.DataReglamentator;
import users.User;
import java.util.NoSuchElementException;
import java.util.Scanner;

class LoginHandler {
    private DataReglamentator dataReglamentator;
    private User loggedInUser;

    LoginHandler(DataReglamentator dataReglamentator) {
        this.dataReglamentator = dataReglamentator;
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
        boolean isloginInfoWrong = true;
        while (isloginInfoWrong)
        if (isUserInDatabase(getEmailFromUser())) {
            if (isPasswordCorrect(getPasswordFromUser())) {
                System.out.println("Good! Yo're in.");
                isloginInfoWrong = false;
                return true;
            }
        }
        return false;
    }

    private boolean isUserInDatabase(String email) {
        try {
            loggedInUser = dataReglamentator.getUserByEmail(email);
        }
        catch (NoSuchElementException e) {
            System.out.println("There is no such user. :(");
            return false;
        }
        return true;
    }

    private boolean isPasswordCorrect(String passFromUser) {
        String passFromDatabase = loggedInUser.getPassword();
        if ((passFromUser.equals(passFromDatabase))) return true;
        else {
            System.out.println("Wrong password.");
            return false;
        }
    }

    User getLoggedInUser() {
        return loggedInUser;
    }
}
