package com.twu.biblioteca;

import java.util.List;

public class User {
    private String libraryNumber;
    private String password;
    private List<User> usersList;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    Boolean login(String libraryNumber, String password){
        for(User user: usersList){
            if(!libraryNumber.equals(user.getLibraryNumber()) && !password.equals(user.getPassword())){
                return false;
            }
        }
        return true;
    }
}
