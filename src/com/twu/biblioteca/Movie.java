package com.twu.biblioteca;

public class Movie extends Resource{
    private String director;

    public Movie(String name, Boolean available, String year, String director) {
        super(name, available, year);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public String toString(){
        return String.format("|%20s|%20s|%20s|\n", getName(), director, getYear());
    }
}
