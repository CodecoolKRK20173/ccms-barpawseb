import database.LoaderSaver;
import java.io.IOException;

class CcMS {
    CcMS() throws IOException {
        LoaderSaver users = new LoaderSaver();
        users.loadUsersList("src/database/users.csv");
        users.displayAllUsers();
    }
}
