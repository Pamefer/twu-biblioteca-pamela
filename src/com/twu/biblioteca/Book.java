package com.twu.biblioteca;

public class Book extends Resource {
    private String author;

    public Book(String name, Boolean available, String year, String author){
        super(name, available, year);
        this.author = author;
    }

    public Book(){}


    public String getAuthor() {
        return this.author;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|\n", getName(), author, getYear());
    }

}
