package users;

import java.util.Scanner;

public abstract class User{
    
    protected String name;
    protected String password;
    static String defaultPassword = "user";
    static int nextId = 1;
    protected String id;
    

    public User (String name){
        this.name = name;
        this.password = defaultPassword + name;
        setID();
    }

    public User (String name, String password, String id){
        this.name = name;
        this.password = password;
        this.id = id;
        nextId = id;
    }

    public void setID(){
        id = nextId;
        nextId++;
    }

    private void setPassword (Scanner in){
        password = in.nextLine();
    }
        



}
