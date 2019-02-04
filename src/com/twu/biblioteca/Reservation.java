package com.twu.biblioteca;

public class Reservation {
    private User user;
    private Resource resource;

    public Reservation(User user, Resource resource) {
        this.user = user;
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public Resource getResource() {
        return resource;
    }

    public String toString(){
        return String.format("Library Number: %5s\nBook:%20s", getUser().getLibraryNumber(), getResource());
    }
}
