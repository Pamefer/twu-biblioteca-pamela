package com.twu.biblioteca;

import java.util.List;

public class User {
    private String libraryNumber;
    private String password;

    private Boolean statusSession;

    public User(String libraryNumber, String password, Boolean statusSession) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.statusSession = statusSession;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getStatusSession() {
        return statusSession;
    }

    public void setStatusSession(Boolean statusSession) {
        this.statusSession = statusSession;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|\n", getLibraryNumber(), getPassword(), getStatusSession());
    }

}
