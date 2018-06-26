package users;

import java.util.Scanner;

public abstract class User{
    protected String name;
    protected String password;
    static String defaultPassword = "user";
    static int nextId = 1;
    protected int id;

    public User (String name){
        this.name = name;
        this.password = defaultPassword + name;

        setID();
    }

    public void setID(){
        id = nextId;
        nextId++;
    }

    private void setPassword (Scanner in){
        password = in.nextLine();
    }
}