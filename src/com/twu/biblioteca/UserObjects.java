package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserObjects {
    private List<User> usersList;

    public UserObjects() {
        this.usersList = new ArrayList<>();
        this.usersList.add( new User("1", "1234", false, "Jony", "jon@gmail.com", "0989906930"));
        this.usersList.add( new User("2", "1234", false,"jose", "jose@gmail.com", "78658437563"));
        this.usersList.add( new User("3", "1234", false, "pancha", "pancha@gmail.com", "634353455"));
    }

    public List<User> getUsersList() {
        return usersList;
    }

    Boolean login(String libraryNumber, String password){
        Boolean isLoginCorrect = false;
        for(User user: getUsersList()){
            if(libraryNumber.equals(user.getLibraryNumber()) && password.equals(user.getPassword())){
                isLoginCorrect = true;
                user.setStatusSession(true);
            }
        }
        return isLoginCorrect;
    }

    User activeUser(){
        User userPerson = null;
        for(User user: usersList){
            if(user.getStatusSession()){
                userPerson = user;
            }
        }
        return  userPerson;
    }

}
