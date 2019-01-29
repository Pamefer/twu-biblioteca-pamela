package com.twu.biblioteca;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
    public void shouldReturnListOfBooks(){
        String expected = "The Japanese girl\nYour life\nTake me out\n";
        String actual = new Biblioteca().getListOfBooks();
        assertEquals(expected, actual);
    }
}
