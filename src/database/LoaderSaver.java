package database;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoaderSaver {
    private List<String> users = new ArrayList<>();

    public void loadUsersList(String fileName) throws IOException {
        Scanner scan = new Scanner(Paths.get(fileName));
        while (scan.hasNextLine()) {
            users.add(scan.nextLine());
        }
    }

    public void displayAllUsers() {
        for (String user : users) {
            System.out.println(user);
        }
    }

    public String[] userInfo(String singleUser) {
        String[] parts = singleUser.split(",");
        System.out.println(parts[0]);
        System.out.println(parts[1]);
        return parts;
    }
}
