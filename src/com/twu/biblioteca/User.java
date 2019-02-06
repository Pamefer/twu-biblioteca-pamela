package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String mail;
    private String phone;

    private Boolean statusSession;

    public User(String libraryNumber, String password, Boolean statusSession, String name, String mail, String phone) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.statusSession = statusSession;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
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

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setStatusSession(Boolean statusSession) {
        this.statusSession = statusSession;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|\n", getLibraryNumber(), getPassword(), getStatusSession());
    }


}
