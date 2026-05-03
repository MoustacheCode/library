package com.library.user;

import com.library.CsvUtils;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
        loadUsers();
    }

    private void loadUsers() {
        List<User> loaded = CsvUtils.loadUsers();
        if (loaded != null) {
            this.users = loaded;
        }
    }

    public void saveUsers() {
        CsvUtils.saveUsers(users);
    }
    // create user
    public boolean createUser(String username, String password, boolean isAdmin) {
        if (findUserbyUsername(username) != null) {
            return false; // user exists
        }

        User newUser = new User(username, password, isAdmin);
        users.add(newUser);
        saveUsers();
        return true;
    }

    public User findUserbyUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // logged in
            }
        }
        return null; // wrong details/ failed login
    }

    public User validateLogin(String username, String password) {
        User u = findUserbyUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }




}
