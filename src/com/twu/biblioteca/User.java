package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String mail;
    private String phone;

    public User() {
    }

    public User(String libraryNumber, String password, Boolean statusSession, String name, String mail, String phone) {
        this.libraryNumber = libraryNumber;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }


    public String toString(){
        return String.format("Name: %-20s\nEmail: %-20s\nPhone number: %-20s\n", getName(), getMail(), getPhone());
    }


}
