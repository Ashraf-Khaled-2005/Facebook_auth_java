package com.example.facebooklogin;

public class User {
    private int id;
    private  String email;
    private String pass;
    private String username;

    public User(String email, String pass, String username) {
        this.email = email;
        this.pass = pass;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(int id, String email, String pass, String username) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.username = username;
    }
}
