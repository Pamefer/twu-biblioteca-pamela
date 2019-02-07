package com.twu.biblioteca.collection.productSet;

import com.twu.biblioteca.collection.userSet.User;

public class Movie implements BibliotecaProduct {
    private String name;
    private Boolean available;
    private User rentedBy;
    private String director;
    private String rating;
    private String year;

    public Movie(String name, Boolean available, User rentedBy, String year, String director, String rating) {
        this.name = name;
        this.available = available;
        this.rentedBy = rentedBy;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public User getRentedBy() {
        return this.rentedBy;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setRentedBy(User rentedBy) {
        this.rentedBy = rentedBy;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|%20s|\n", name, director, year, rating);
    }
}
