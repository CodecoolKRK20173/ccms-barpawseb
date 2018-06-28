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
    private List<String[]> dataLines = new ArrayList<>();
    private final String filePath;

    public DataManager(String filePath) throws IOException {
        this.filePath = filePath;
        loadDataList(filePath);
    }

    private void loadDataList(String fileName) throws IOException {
        Scanner scan = new Scanner(Paths.get(fileName));
        while (scan.hasNextLine()) {
            String[] data = scan.nextLine().split(",");
            dataLines.add(data);
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

        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Iterator<String[]> iterator() {
        return dataLines.iterator();
    }

    public void setUsersLines(List<String[]> lines){ //overwrites list with content to be written to data base;
        dataLines = lines;
        saveListToDatabase(dataLines);
    }
}
