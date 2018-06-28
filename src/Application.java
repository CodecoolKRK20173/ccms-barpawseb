import controllers.MentorController;
import controllers.SimpleEmployeeController;
import controllers.StudentController;
import controllers.SupervisorController;
import database.DataReglamentator;
import users.User;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        System.out.println(status);

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
        boolean isRunning = true;
        while(isRunning) {
            studentController.showManu();
            System.out.print("What's your choice? ");
            int option = this.getChoice(1, 5, true);
            if (option == 1) {

            }
            else if (option == 2) {
                studentController.showGrades();
            }
            else if (option == 3) {
                studentController.setPassword();
            }
            else if (option == 4) {
                studentController.showData();
            }
            else if (option == 5) {
                isRunning = false;
            }
        }
    }

    private void handleMentorController(String email) {
        MentorController mentorController = new MentorController(dataReglamentator, email);
        boolean isRunning = true;
        while(isRunning) {
            mentorController.showManu();
            System.out.print("What's your choice? ");
            int option = this.getChoice(1, 9, true);
            if (option == 1) {
                mentorController.showStudents();
            }
            else if (option == 2) {
                mentorController.addStudent();
            }
            else if (option == 3) {
                mentorController.removeStudent();
            }
            else if (option == 4) {
                mentorController.showStudentsData();
            }
            else if (option == 5) {
                mentorController.checkAttendence();
            }
            else if (option == 6) {

            }
            else if (option == 7) {

            }
            else if (option == 8) {
                mentorController.setPassword();
            }
            else if (option == 9) {
                isRunning = false;
            }
        }

    }
    private void handleSimpleEmploeeController(String email) {
        SimpleEmployeeController simpleEmployeeController = new SimpleEmployeeController(dataReglamentator, email);
        boolean isRunning = true;
        while(isRunning) {
            simpleEmployeeController.showManu();
            System.out.print("What's your choice? ");
            int option = this.getChoice(1, 4, true);
            if (option == 1) {
                simpleEmployeeController.showMentors();
            }
            else if (option == 2) {
                simpleEmployeeController.showStudents();
            }
            else if (option == 3) {
                simpleEmployeeController.setPassword();
            }
            else if (option == 4) {
                isRunning = false;
            }
        }

    }
    private void handleSupervisorController(String email) {
        SupervisorController supervisorController = new SupervisorController(dataReglamentator, email);
        boolean isRunning = true;
        while(isRunning) {
            supervisorController.showManu();
            System.out.print("What's your choice? ");
            int option = this.getChoice(1, 7, true);
            if (option == 1) {
                supervisorController.addMentor();
            }
            else if (option == 2) {
                supervisorController.removeMentor();
            }
            else if (option == 3) {
                supervisorController.showMentorsData();
            }
            else if (option == 4) {
                supervisorController.showMentors();
            }
            else if (option == 5) {
                supervisorController.showStudents();
            }
            else if (option == 6) {
                supervisorController.changeEmploeeSalary();
            }
            else if (option == 7) {
                isRunning = false;
            }
        }
    }

    private static int getChoice(int min, int max, boolean showErrorMessage) {
        Scanner reader;
        boolean stop = false;
        int option = 0;
        while(!stop) {
            reader = new Scanner(System.in);
            try {
                option = reader.nextInt();
                if(option >= min && option <= max) {
                    stop = true;
                }
                else if (showErrorMessage) {
                    System.out.println("\nThere is no such option!");
                }
                else {
                    System.out.print("\nNumber is out of range! Try again: ");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("\nWrong input. Try again!");
            }
        }
        return option;
    }
}
