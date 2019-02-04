package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserObjects {
    private List<User> usersList;

    public UserObjects() {
        this.usersList = new ArrayList<>();
        this.usersList.add( new User("000-0001", "1234"));
        this.usersList.add( new User("000-0002", "1234"));
        this.usersList.add( new User("000-0003", "1234"));
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
