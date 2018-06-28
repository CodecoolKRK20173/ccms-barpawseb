import controllers.MentorController;
import controllers.SimpleEmployeeController;
import controllers.StudentController;
import controllers.SupervisorController;
import database.DataReglamentator;
import users.User;

import java.io.IOException;

class Application {
    private User loggedInUser;
    public DataReglamentator dataReglamentator;

    Application() {
        try {
            dataReglamentator = new DataReglamentator();
            LoginHandler loginHandler = new LoginHandler(dataReglamentator);
            if (loginHandler.isLoggedIn()) {
                loggedInUser = loginHandler.getLoggedInUser();
                chooseController();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void chooseController() {
        String email = loggedInUser.getEmail();
        String status = loggedInUser.getStatus();

        if (status.equals("Student"))
            handleStudentController(email);
        else if (status.equals("Mentor"))
            handleMentorController(email);
        else if (status.equals("Employee"))
            handleSimpleEmploeeController(email);
        else if (status.equals("Supervisor"))
            handleSupervisorController(email);
    }

    private void handleStudentController(String email) {
        StudentController studentController = new StudentController(dataReglamentator, email);
    }

    private void handleMentorController(String email) {
        MentorController mentorController = new MentorController(dataReglamentator, email);

    }
    private void handleSimpleEmploeeController(String email) {
        SimpleEmployeeController simpleEmployeeController = new SimpleEmployeeController(dataReglamentator, email);

    }
    private void handleSupervisorController(String email) {
        SupervisorController supervisorController = new SupervisorController(dataReglamentator, email);
    }
}
