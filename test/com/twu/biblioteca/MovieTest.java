package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    Movie movie;

    @Before
    public void chargeMovie(){
        movie = new Movie("Sky", true, "2016", "Adam Sandler");
    }

    @Test
    public void shouldReturnDirector(){
        String actual = movie.getDirector();
        assertEquals("Adam Sandler", actual);
    }
}
