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

    public User (String name, String password, int id){
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

    public int getId(){
        return id;
    }

    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        User o = (User) obj;
        return o.getId() == this.getId();
    }

}
