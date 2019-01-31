package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String year;
    private Boolean available;

    public Book(String name, String author, String year, Boolean available){
        this.name = name;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }
}
