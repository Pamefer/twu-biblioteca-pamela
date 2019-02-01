package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Before
    public void chargeMovie(){
        Movie movie = new Movie("Sky", true, "2016", "Adam Sandler");
    }

    @Test
    public void shouldReturnDirector(){
        String actual = movie.getDirector();
        assertEquals("Adam Sandler", actual);
    }
}
