package com.twu.biblioteca;

public class Movie extends BibliotecaProduct {
    private String director;
    private String rating;
    private String year;

    public Movie(String name, Boolean available, User rentedBy, String year, String director, String rating) {
        super(name, available, rentedBy);
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|%20s|\n", getName(), director, year, rating);
    }
}
