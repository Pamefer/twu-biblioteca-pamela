package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MenuTest {
    private Biblioteca biblioteca;
    List<BibliotecaProduct> bibliotecaProductList;
    private User user = new User();


    @Before
    public void chargeDate(){
        bibliotecaProductList= new ArrayList<>();
        bibliotecaProductList.add(new Book("The Japanese girl", true, user,"1971", "Winston Graham"));
        bibliotecaProductList.add(new Book("You",true, user, "2015", "Pamela"));
        bibliotecaProductList.add(new Book("Take me out",true, user, "1987", "Gianella"));
        bibliotecaProductList.add(new Movie("Movie1", true, user, "1971", "Winston Graham", "3"));
        bibliotecaProductList.add(new Movie("Movie2",true, user, "2015", "Pamela","4"));
        bibliotecaProductList.add(new Movie("Movie3",true, user, "1987", "Gianella","5"));
        biblioteca = new Biblioteca(bibliotecaProductList);
    }

    @Test
    public void shouldReturnValidOptionMenu(){
        Boolean expected = true;
        Menu menu = new Menu(biblioteca, user);
        Boolean actual = new Utililty().isValidOption("2", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuOutOfRange(){
        Boolean expected = false;
        Menu menu = new Menu(biblioteca, user);
        Boolean actual = new Utililty().isValidOption("9", menu.getOptionsList());
        assertEquals(expected, actual);
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
