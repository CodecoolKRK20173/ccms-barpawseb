import controllers.MentorController;
import controllers.SimpleEmployeeController;
import controllers.StudentController;
import controllers.SupervisorController;

import java.io.IOException;

class Application {
    private String[] loggedInUserDetails;

    Application() throws IOException {
        LoginHandler loginHandler = new LoginHandler();
        if (loginHandler.isLoggedIn()) {
            loggedInUserDetails = loginHandler.getloggedInUserDetails();
            chooseController();
        }
    }

    private void chooseController() {
        String email = loggedInUserDetails[0];
        String firstName = loggedInUserDetails[1];
        String secondName = loggedInUserDetails[2];
        String password = loggedInUserDetails[3];
        String status = loggedInUserDetails[4];
        double grade = Double.parseDouble(loggedInUserDetails[5]);
        double salary = Double.parseDouble(loggedInUserDetails[6]);

        if (status.equals("s"))
            handleStudentController(email, firstName, secondName, password, grade);
        else if (status.equals("m"))
            handleMentorController(email, firstName, secondName, password, salary);
        else if (status.equals("e"))
            handleSimpleEmploeeController(email, firstName, secondName, password, salary);
        else if (status.equals("j"))
            handleSupervisorController(email, firstName, secondName, password, salary);
    }

    private void handleStudentController(String email, String firstName, String secondName, String password, double grade) {
        StudentController studentController = new StudentController(email, firstName, secondName, password, grade);
    }

    private void handleMentorController(String email, String firstName, String secondName, String password, double salary) {
        MentorController mentorController = new MentorController(email, firstName, secondName, password, salary);

    }
    private void handleSimpleEmploeeController(String email, String firstName, String secondName, String password, double salary) {
        SimpleEmployeeController simpleEmployeeController = new SimpleEmployeeController(email, firstName, secondName, password, salary);

    }
    private void handleSupervisorController(String email, String firstName, String secondName, String password, double salary) {
        SupervisorController supervisorController = new SupervisorController(email, firstName, secondName, password, salary);

    }
}
