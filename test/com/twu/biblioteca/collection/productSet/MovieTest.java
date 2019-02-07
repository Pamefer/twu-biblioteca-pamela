package com.twu.biblioteca.collection.productSet;

import com.twu.biblioteca.collection.productSet.Movie;
import com.twu.biblioteca.collection.userSet.User;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    Movie movie;

    @Before
    public void chargeMovie(){
        User user = new User();
        movie = new Movie("Sky", true, user, "2016", "Adam Sandler", "3");
    }

//    @Test
//    public void shouldReturnDirector(){
//        String actual = movie.getDirector();
//        assertEquals("Adam Sandler", actual);
//    }
//
//    @Test
//    public void shouldReturnRating(){
//        String actual = movie.getRating();
//        assertEquals("3", actual);
//    }
}
