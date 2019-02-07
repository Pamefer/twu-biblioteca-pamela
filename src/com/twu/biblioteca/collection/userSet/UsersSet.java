package com.twu.biblioteca.collection.userSet;

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
        User userLogged = null;
        for(User user: getUsersList()){
            if(libraryNumber.equals(user.getLibraryNumber()) && password.equals(user.getPassword())){
                userLogged = user;
            }
        }
        return userLogged;
    }

    public Boolean isUserLogged(User userLogged){
        return userLogged != null;
    }
}
