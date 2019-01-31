package com.twu.biblioteca;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    public void shouldReturnNameOfBook() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
        String actual = new Biblioteca().welcomeMessage();
        assertEquals(expected, actual);
    }
}
