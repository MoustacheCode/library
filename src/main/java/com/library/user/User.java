package com.library.user;

public class User {

    private String username;
    private String password;
    private boolean isAdmin;


    public User(String userName, String password, boolean isAdmin) {
        this.username = userName;
        this.password = password;
        this.isAdmin = isAdmin;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}