package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @Before
    public void chargeUserObject(){
        biblioteca = new Biblioteca();
    }

    @Test
    public void shouldReturnWelcomeMessage() {
        String expected = "\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
        String actual = biblioteca.welcomeMessage();
        assertEquals(expected, actual);
    }
}
