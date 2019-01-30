package com.twu.biblioteca;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.*;

public class ExampleTest {
    List<Book> listBooks = new ArrayList<>();

    public void booksList(){
        listBooks.add(new Book("The Japanese girl", "Winston Graham", "1971"));
        listBooks.add(new Book("You","Pamela","2015"));
        listBooks.add(new Book("Take me out","Gianella","1987"));
    }

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
    public void shouldReturnValidOptionMenu(){
        Boolean expected = true;
        Boolean actual = new Biblioteca().isValidOption("1");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuOutOfRange(){
        Boolean expected = false;
        Boolean actual = new Biblioteca().isValidOption("5");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuNotNumber(){
        Boolean expected = false;
        Boolean actual = new Biblioteca().isValidOption("j");
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
    public void shouldBeOneBookLessFromAllBooks(){
        int numberBookExpected = 2;
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.removeBook("You");
        int numberBooksActual = biblioteca.getListBooks().size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

    @Test
    public void shouldDoNotBeInTheListOfBooks(){
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.removeBook("You");
        List<Book> listBooksExpected =  biblioteca.getListBooks();
        assertFalse(listBooksExpected.contains(
                new Book ("Take me out","Gianella","1987")
        ));
    }

    @Test
    public void shouldReturnSuccessMessageIfCheckOutTrue(){
        String successMessageExpected = "Thank you, enjoy the book";
        Boolean isCheckOut = true;

        String successMessageActual = new Biblioteca().returnMessage(isCheckOut);

        assertEquals( successMessageExpected, successMessageActual);
    }



}
