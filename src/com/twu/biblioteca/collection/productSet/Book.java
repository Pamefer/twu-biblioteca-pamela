package com.twu.biblioteca.collection.productSet;

import com.twu.biblioteca.collection.userSet.User;

public class Book implements BibliotecaProduct {
    private String name;
    private Boolean available;
    private User rentedBy;
    private String year;
    private String author;

    public Book(String name, Boolean available, User rentedBy, String year, String author){
        this.name = name;
        this.available = available;
        this.rentedBy = rentedBy;
        this.year = year;
        this.author = author;
    }

    public String getName() {
        return name;
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


    public String toString(){
        return String.format("|%20s|%20s|%20s|\n", name, author, year);
    }

}
