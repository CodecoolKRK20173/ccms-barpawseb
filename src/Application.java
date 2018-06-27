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
        String name = loggedInUserDetails[1];
        String password = loggedInUserDetails[2];
        String status = loggedInUserDetails[3];
        double grade = Double.parseDouble(loggedInUserDetails[4]);
        double salary = Double.parseDouble(loggedInUserDetails[5]);

        if (status.equals("s"))
            handleStudentController(email, name, password, grade);
        else if (status.equals("m"))
            handleMentorController(email, name, password, salary);
        else if (status.equals("e"))
            handleSimpleEmploeeController(email, name, password, salary);
        else if (status.equals("j"))
            handleSupervisorController(email, name, password, salary);
    }

    private void handleStudentController(String email, String name, String password, double grade) {
        StudentController studentController = new StudentController(email, name, password, grade);
    }

    private void handleMentorController(String email, String name, String password, double salary) {
        MentorController mentorController = new MentorController(email, name, password, salary);

    }
    private void handleSimpleEmploeeController(String email, String name, String password, double salary) {
        SimpleEmployeeController simpleEmployeeController = new SimpleEmployeeController(email, name, password, salary);

    }
    private void handleSupervisorController(String email, String name, String password, double salary) {
        SupervisorController supervisorController = new SupervisorController(email, name, password, salary);
    }
}
