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

    public User login(String libraryNumber, String password){
        User u = null;
        //Boolean isLoginCorrect = false;
        for(User user: getUsersList()){
            if(libraryNumber.equals(user.getLibraryNumber()) && password.equals(user.getPassword())){
                //isLoginCorrect = true;
                u = user;
                user.setStatusSession(true);
            }
        }
        return u;
    }
}
