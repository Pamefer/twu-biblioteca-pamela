package com.twu.biblioteca;

public class Book extends BibliotecaProduct {
    private String author;
    private String year;

    public Book(String name, Boolean available, User rentedBy, String year, String author){
        super(name, available, rentedBy);
        this.author = author;
        this.year = year;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|\n", getName(), author, year);
    }

}
