package com.twu.biblioteca;


import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.*;

public class ExampleTest {
    List<Book> listBooks = new ArrayList<>();

    @Test
    public void shouldReturnWelcomeMessage() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
        String actual = new Biblioteca().welcomeMessage();
        assertEquals(expected, actual);
    }

//    @Test
//    public void shouldShowListOfOptions(){
//        String expected = "1. List of Books\n2. Quit\n";
//        String actual = new Biblioteca().showOptions();
//        assertEquals(expected, actual);
//    }

    @Test
    public void shouldReturnValidOptionMenu(){
        Boolean expected = true;
        Biblioteca biblioteca = new Biblioteca();
        Boolean actual = new Biblioteca().isValidOption("2", biblioteca.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuOutOfRange(){
        Boolean expected = false;
        Biblioteca biblioteca = new Biblioteca();
        Boolean actual = new Biblioteca().isValidOption("5", biblioteca.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuNotNumber(){
        Boolean expected = false;
        Biblioteca biblioteca = new Biblioteca();
        Boolean actual = new Biblioteca().isValidOption("j", biblioteca.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnStringOfBooks(){

        String expected = String.format("|%20s|%20s|%20s|\n|%20s|%20s|%20s|\n|%20s|%20s|%20s|\n",
                "The Japanese girl", "Winston Graham", "1971",
                "You","Pamela","2015",
                "Take me out","Gianella","1987");
        String actual = new Biblioteca().getBooks();
        assertEquals(expected, actual);
    }

    @Test
    public void hasBeenChekoutABook(){
        Biblioteca biblioteca = new Biblioteca();

        boolean isCheckoutActual = biblioteca.checkoutBook("You");

        assertTrue(isCheckoutActual);
    }

    @Test
    public void shouldBeOneBookLessFromAllBooksIfCheckOut(){
        int numberBookExpected = 2;
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.checkoutBook("You");
        int numberBooksActual = biblioteca.getListBooksAvailable().size();
        assertEquals(numberBookExpected, numberBooksActual);
    }


    @Test
    public void shouldNotBeOneBookLessFromAvailableBooksIfBookNotExist(){
        int numberBookExpected = 3;
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.checkoutBook("Me");
        int numberBooksActual = biblioteca.getListBooksAvailable().size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

    @Test
    public void shouldReturnSuccessMessageIfCheckOutTrue(){
        String successMessageExpected = "Thank you, enjoy the book";
        Boolean isCheckOut = true;

        String successMessageActual = new Biblioteca().returnMessage(isCheckOut);

        assertEquals( successMessageExpected, successMessageActual);
    }

    @Test
    public void shouldReturnUnSuccessMessageIfBookIsNotAvailable(){
        String unsuccessMessageExpected = "Sorry, that book is not available";
        Boolean isCheckOut = false;

        String unsuccessMessageActual = new Biblioteca().returnMessage(isCheckOut);

        assertEquals( unsuccessMessageExpected, unsuccessMessageActual);
    }

    @Test
    public void hasBeenReturnedABook(){
        Biblioteca biblioteca = new Biblioteca();

        boolean isReturnActual = biblioteca.returnBook("You");

        assertTrue(isReturnActual);
    }

    @Test
    public void shouldBeOneBookMoreFromAvailableBooksIfIsReturned(){
        int numberBookExpected = 3;
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.returnBook("You");
        int numberBooksActual = biblioteca.getListBooksAvailable().size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

}
