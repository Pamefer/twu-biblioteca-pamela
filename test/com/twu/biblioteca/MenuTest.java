package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MenuTest {
    private UserObjects userObject;
    private Biblioteca biblioteca;
    private Utililty utililty;
    private Menu menu;

    @Before
    public void chargeUserObject(){
        userObject = new UserObjects();
        biblioteca = new Biblioteca();
        utililty = new Utililty();
        userObject.login("1","1234");
        menu = new Menu(biblioteca, userObject);
    }

    @Test
    public void shouldReturnValidOptionMenu(){
        Boolean expected = true;
        System.out.println( menu.getOptionsList());
        Boolean actual = utililty.isValidOption("2", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuOutOfRange(){
        Boolean expected = false;
        Boolean actual = utililty.isValidOption("8", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuNotNumber(){
        Boolean expected = false;
        Boolean actual = utililty.isValidOption("jjjjj", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfNotSelectOptionOfQuit() {
        Boolean actual = menu.isOptionToQuit(6);
        assertFalse(actual);
    }
}
