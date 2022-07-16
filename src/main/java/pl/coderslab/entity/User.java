package pl.coderslab.entity;

public class User {
    //list of parameters
    private int id;
    private String email;
    private String username;
    private String password;
    public User(){}; //parameterless constructor --> params(above) set to default values.


    // setters and getters below list.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
