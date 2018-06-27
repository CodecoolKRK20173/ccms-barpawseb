package database;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataManager implements Iterable<String[]> {
    private List<String[]> users = new ArrayList<>();

    public DataManager() throws IOException {
        loadUsersList("src/database/users.csv");
    }

    private void loadUsersList(String fileName) throws IOException {
        Scanner scan = new Scanner(Paths.get(fileName));
        while (scan.hasNextLine()) {
            String[] userDetails = scan.nextLine().split(",");
            users.add(userDetails);
        }
    }

    public Iterator<String[]> iterator() {
        return users.iterator();
    }
}
