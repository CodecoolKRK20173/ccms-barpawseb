package database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataManager implements Iterable<String[]> {
    private List<String[]> usersLines = new ArrayList<>();
    private final String usersDbLocation = "src/database/users.csv";

    public DataManager() throws IOException {
        loadUsersList(usersDbLocation);
    }

    private void loadUsersList(String fileName) throws IOException {
        Scanner scan = new Scanner(Paths.get(fileName));
        while (scan.hasNextLine()) {
            String[] userDetails = scan.nextLine().split(",");
            usersLines.add(userDetails);
        }
    }

    public void saveListToDatabase(List<String[]> dataList) {
        boolean firstLine = true;
        StringBuilder sb = new StringBuilder();
        for (String[] line : dataList) {
            String joinedLine = String.join(",", line);
            if (firstLine)
                firstLine = false;
            else {
                sb.append("\n");
            }
            sb.append(joinedLine);
        }
        String text = sb.toString();

        try (PrintWriter out = new PrintWriter(usersDbLocation)) {
            out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Iterator<String[]> iterator() {
        return usersLines.iterator();
    }

    public void setUsersLines(List<String[]> lines){ //overwrites list with content to be written to data base;
        usersLines = lines;
    }
}
