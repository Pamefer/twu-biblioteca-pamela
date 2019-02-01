package com.twu.biblioteca;

public class Movie extends Resource{
    private String director;
    private String rating;

    public Movie(String name, Boolean available, String year, String director, String rating) {
        super(name, available, year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|%20s|\n", getName(), director, getYear(), rating);
    }
}
