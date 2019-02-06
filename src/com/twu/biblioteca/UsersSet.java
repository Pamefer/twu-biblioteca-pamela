package com.twu.biblioteca;

import java.util.List;

public class UsersSet {

    public List<User> usersList;

    public List<User> getUsersList() {
        return usersList;
    }

    public void chargeUsers(List<User> usersList) {
        this.usersList = usersList;
    }

    public Boolean login(String libraryNumber, String password){
        Boolean isLoginCorrect = false;
        for(User user: getUsersList()){
            if(libraryNumber.equals(user.getLibraryNumber()) && password.equals(user.getPassword())){
                isLoginCorrect = true;
                user.setStatusSession(true);
            }
        }
        return isLoginCorrect;
    }
}
