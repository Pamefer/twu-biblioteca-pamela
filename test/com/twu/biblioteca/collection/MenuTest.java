package com.twu.biblioteca.collection;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Utililty;
import com.twu.biblioteca.collection.userSet.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private Biblioteca biblioteca;
    private User user = new User();

    @Before
    public void chargeDate(){
        biblioteca = new Biblioteca(BibliotecaApp.chargeBibliotecaProducts());
    }

    @Test
    public void shouldReturnValidOptionMenu(){
        String option = "2";
        Menu menu = new Menu(biblioteca, user);
        Boolean actual = new Utililty().isValidOption(option, menu.getOptionsList());
        assertTrue(actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuOutOfRange(){
        String option = "8";
        Menu menu = new Menu(biblioteca, user);
        Boolean actual = new Utililty().isValidOption(option, menu.getOptionsList());
        System.out.println(actual);
        assertFalse(actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuNotNumber(){
        Boolean expected = false;
        Menu menu = new Menu(biblioteca, user);
        Boolean actual = new Utililty().isValidOption("jjjjj", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfNotSelectOptionOfQuit() {
        Boolean actual = new Menu(biblioteca, user).isOptionToQuit(0);
        assertFalse(actual);
    }
}
