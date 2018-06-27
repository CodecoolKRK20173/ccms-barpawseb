package users;

import java.util.Scanner;

public abstract class User{
    
    private String name;
    private String password;
    static String defaultPassword = "user";
    private String email;
    

    public User (String name, String email){
        this.name = name;
        this.password = defaultPassword +""+ name;
        this.email = email;
    }

    public User (String name, String email, String password){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    protected void setPassword (Scanner in){
        password = in.nextLine();
    }

    public String getEmail(){
        return email;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return password;
    }
    
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        User o = (User) obj;
        return o.getEmail().equals(this.getEmail());
    }

    public String toString(){
        return String.format("Name: %s\n\t\te-mail: %s\n", name, email);
    }

}
