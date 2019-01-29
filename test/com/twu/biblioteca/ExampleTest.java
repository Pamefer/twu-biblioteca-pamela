package com.twu.biblioteca;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExampleTest {
    private List<String> strings;


    @Test
    public void shouldReturnWelcomeMessage() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
        String actual = new Biblioteca().welcomeMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowListOfOptions(){
        String expected = "1. List of Books\n";
        String actual = new Biblioteca().showOptions();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValidOption(){
        Boolean expected = true;
        Boolean actual = new Biblioteca().isValidOption(1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOption(){
        Boolean expected = false;
        Boolean actual = new Biblioteca().isValidOption(0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnStringOfBooks(){
        String expected = "The Japanese girl\nYour life\nTake me out\n";
        String actual = new Biblioteca().getListOfBooks();
        assertEquals(expected, actual);
    }
}
