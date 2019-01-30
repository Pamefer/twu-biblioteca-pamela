package com.twu.biblioteca;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExampleTest {

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
        Boolean actual = new Biblioteca().isValidOption("1");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOption(){
        Boolean expected = false;
        Boolean actual = new Biblioteca().isValidOption("2");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnStringOfBooks(){

        String expected = String.format("|%20s|%20s|%20s|\n|%20s|%20s|%20s|\n|%20s|%20s|%20s|\n",
                "The Japanese girl", "Winston Graham", "1971",
                "Your life","Pamela","2015",
                "Take me out","Gianella","1987");
        String actual = new Biblioteca().getBooks();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeOneBookLessFromAllBooks(){
        int numberBookExpected = 2;
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.removeBook();
        int numberBooksActual = biblioteca.getListBooks().size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

//    @Test
//    public void shouldRemoveBookFromList(){
//        String bookRemoved = "Your life";
//        Biblioteca biblioteca = new Biblioteca();
//
//        List<Book> listBooksExpected = biblioteca.removeBook();
//
//        listBooksExpected.forEach(item ->
//                assertNotEquals(bookRemoved, item.getAuthor())
//        );
//
//    }

}
