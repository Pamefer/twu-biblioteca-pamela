package com.twu.biblioteca.collection.productSet;

import com.twu.biblioteca.collection.productSet.Movie;
import com.twu.biblioteca.collection.userSet.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    Movie movie;

    @Before
    public void chargeMovie() {
        User user = new User();
        movie = new Movie("Sky", true, user, "2016", "Adam Sandler", "3");
    }

    @Test
    public void shouldGetNameOfMovie() {
        String actual = movie.getName();
        assertEquals("Sky", actual);
    }

    @Test
    public void shouldGetAvailabilityOfMovie() {
        Boolean actual = movie.getAvailable();
        assertTrue(actual);
    }

    @Test
    public void shouldGetYearOfBook() {
        String name = "Sky";
        String director = "Adam Sandler";
        String year = "2016";
        String movieCast = movie.toString();
        assertTrue(movieCast.contains(name) && movieCast.contains(director) && movieCast.contains(year));
    }
}
