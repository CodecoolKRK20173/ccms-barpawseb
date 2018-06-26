package database;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataManager implements Iterable<String> {
    private List<String> users = new ArrayList<>();


    public List<String> loadUsersList(String fileName) throws IOException {
        Scanner scan = new Scanner(Paths.get(fileName));
        while (scan.hasNextLine()) {
            users.add(scan.nextLine());
        }
        return users;
    }

//    @Override
//    public boolean hasNext() {
//        return users.iterator().hasNext();
//    }
//
//    @Override
//    public String next() {
//        return users.iterator().next();
//    }

    @Override
    public Iterator<String> iterator() {
        return users.iterator();
    }
}
