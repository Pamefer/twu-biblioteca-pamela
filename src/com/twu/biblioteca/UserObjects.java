package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserObjects {
    private List<User> usersList;

    public UserObjects() {
        this.usersList = new ArrayList<>();
        this.usersList.add( new User("1", "1234"));
        this.usersList.add( new User("2", "1234"));
        this.usersList.add( new User("3", "1234"));
    }

    public List<User> getUsersList() {
        return usersList;
    }

    Boolean login(String libraryNumber, String password){
        Boolean isLoginCorrect = false;
        for(User user: getUsersList()){
            if(libraryNumber.equals(user.getLibraryNumber()) && password.equals(user.getPassword())){
                isLoginCorrect = true;
            }
        }
        return isLoginCorrect;
    }
}
