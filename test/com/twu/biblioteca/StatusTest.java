package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatusTest {
    @Test
    public void shouldReturnNameOfOptionIfNumberOne() {
        String expected = "LIST_BOOK_OPTION";
        Status selection = Status.fetchValue(1);
        assertEquals(expected, selection.toString());
    }

    @Test
    public void shouldReturnNameOfOptionIfNumberTwo() {
        String expected = "LIST_MOVIE_OPTION";
        Status selection = Status.fetchValue(2);
        assertEquals(expected, selection.toString());
    }

    @Test
    public void shouldReturnNameOfOptionIfNumberThree() {
        String expected = "CHECKOUT_BOOK_OPTION";
        Status selection = Status.fetchValue(3);
        assertEquals(expected, selection.toString());
    }

    @Test
    public void shouldReturnNameOfOptionIfNumberFour() {
        String expected = "CHECKOUT_MOVIE_OPTION";
        Status selection = Status.fetchValue(4);
        assertEquals(expected, selection.toString());
    }

    @Test
    public void shouldReturnNameOfOptionIfNumberFive() {
        String expected = "RETURN_BOOK_OPTION";
        Status selection = Status.fetchValue(5);
        assertEquals(expected, selection.toString());
    }

    @Test
    public void shouldReturnNameOfOptionIfNumberSix() {
        String expected = "VIEW_RESERVATIONS_OPTION";
        Status selection = Status.fetchValue(6);
        assertEquals(expected, selection.toString());
    }

    @Test
    public void shouldReturnNameOfOptionIfNumberSeven() {
        String expected = "VIEW_PROFILE_OPTION";
        Status selection = Status.fetchValue(7);
        assertEquals(expected, selection.toString());
    }

    @Test
    public void shouldReturnNameOfOptionIfNumberZero() {
        String expected = "QUIT_OPTION";
        Status selection = Status.fetchValue(0);
        assertEquals(expected, selection.toString());
    }
}
