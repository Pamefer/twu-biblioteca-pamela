package com.twu.biblioteca;

public class Book extends Resource {
    private String author;
    private String year;

    public Book(String name, Boolean available, String author, String year){
        super(name, available);
        this.author = author;
        this.year = year;
    }

    public Book(){}


    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|\n", getName(), author, year);
    }

}
