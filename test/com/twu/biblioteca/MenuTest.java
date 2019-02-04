package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MenuTest {
    private UserObjects userObject;
    @Before
    public void chargeUserObject(){
        userObject = new UserObjects();
        userObject.login("1","1234");
    }

    @Test
    public void shouldReturnValidOptionMenu(){
        Boolean expected = true;
        Biblioteca biblioteca= new Biblioteca(userObject);
        Menu menu = new Menu(biblioteca);
        Boolean actual = new Utililty().isValidOption("2", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuOutOfRange(){
        Boolean expected = false;
        Biblioteca biblioteca= new Biblioteca(userObject);
        Menu menu = new Menu(biblioteca);
        Boolean actual = new Utililty().isValidOption("8", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuNotNumber(){
        Boolean expected = false;
        Biblioteca biblioteca= new Biblioteca(userObject);
        Menu menu = new Menu(biblioteca);
        Boolean actual = new Utililty().isValidOption("jjjjj", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfNotSelectOptionOfQuit() {
        Biblioteca biblioteca = new Biblioteca(userObject);
        Boolean actual = new Menu(biblioteca).isOptionToQuit(6);
        assertFalse(actual);
    }
}
