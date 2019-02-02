package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaTest {
    List<Book> listBooks = new ArrayList<>();

    @Test
    public void shouldReturnWelcomeMessage() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
        String actual = new Biblioteca().welcomeMessage();
        assertEquals(expected, actual);
    }

//    @Test
//    public void shouldReturnFalseIfNotSelectOptionOfQuit() {
//        Boolean actual = new Menu().isOptionToQuit(4);
//        assertFalse(actual);
//    }
//    @Test
//    public void shouldShowListOfOptions(){
//        String expected = "1. List of Books\n2. Quit\n";
//        String actual = new Biblioteca().showOptions();
//        assertEquals(expected, actual);
//    }

    @Test
    public void shouldReturnValidOptionMenu(){
        Boolean expected = true;
        Biblioteca biblioteca= new Biblioteca();
        Menu menu = new Menu(biblioteca);
        Boolean actual = new Utililty().isValidOption("2", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuOutOfRange(){
        Boolean expected = false;
        Biblioteca biblioteca= new Biblioteca();
        Menu menu = new Menu(biblioteca);
        Boolean actual = new Utililty().isValidOption("6", menu.getOptionsList());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnInvalidOptionMenuNotNumber(){
        Boolean expected = false;
        Biblioteca biblioteca= new Biblioteca();
        Menu menu = new Menu(biblioteca);
        Boolean actual = new Utililty().isValidOption("jjjjj", menu.getOptionsList());
        assertEquals(expected, actual);
    }

//    @Test
//    public void shouldReturnStringOfBooks(){
//
//        String expected = String.format("|%20s|%20s|%20s|\n|%20s|%20s|%20s|\n|%20s|%20s|%20s|\n",
//                "The Japanese girl", "Winston Graham", "1971",
//                "You","Pamela","2015",
//                "Take me out","Gianella","1987");
//        String actual = new Biblioteca().listarRecursos();
//        assertEquals(expected, actual);
//    }

    /* Check out book */
    @Test
    public void shouldChekoutABook(){
        Biblioteca biblioteca = new Biblioteca();

        boolean isCheckoutActual = biblioteca.checkoutBook("You");

        assertTrue(isCheckoutActual);
    }

    @Test
    public void shouldNotChekoutABook(){
        Biblioteca biblioteca = new Biblioteca();

        boolean isCheckoutActual = biblioteca.checkoutBook("dgadah");

        assertFalse(isCheckoutActual);
    }

//    @Test
//    public void shouldBeOneBookLessFromAllBooksIfCheckOut(){
//        int numberBookExpected = 2;
//        Biblioteca biblioteca = new Biblioteca();
//
//        biblioteca.checkoutBook("You");
//        int numberBooksActual = biblioteca.getListResourceAvailable().size();
//        assertEquals(numberBookExpected, numberBooksActual);
//    }


//    @Test
//    public void shouldNotBeOneBookLessFromAvailableBooksIfBookNotExist(){
//        int numberBookExpected = 3;
//        Biblioteca biblioteca = new Biblioteca();
//
//        biblioteca.checkoutBook("Me");
//        int numberBooksActual = biblioteca.getListResourceAvailable().size();
//        assertEquals(numberBookExpected, numberBooksActual);
//    }

    @Test
    public void shouldReturnSuccessMessageIfCheckOutTrue(){
        String successMessageExpected = "Thank you, enjoy the book";
        Boolean isCheckOut = true;

        String successMessageActual = new Biblioteca().returnMessageCheckout(isCheckOut);

        assertEquals( successMessageExpected, successMessageActual);
    }

    @Test
    public void shouldReturnUnSuccessMessageIfBookIsNotAvailable(){
        String unsuccessMessageExpected = "Sorry, that book is not available";
        Boolean isCheckOut = false;

        String unsuccessMessageActual = new Biblioteca().returnMessageCheckout(isCheckOut);

        assertEquals( unsuccessMessageExpected, unsuccessMessageActual);
    }

    /* Return Book */

    @Test
    public void shouldReturnABook(){
        Book b = new Book("You", false, "Pamela", "2015");
        Biblioteca biblioteca = new Biblioteca();

        boolean isReturnActual = biblioteca.returnBook(b.getName());

        assertTrue(isReturnActual);
    }

    @Test
    public void shouldNotReturnABook(){
        Biblioteca biblioteca = new Biblioteca();

        boolean isReturnActual = biblioteca.returnBook("Adasdasd");

        assertFalse(isReturnActual);
    }

//    @Test
//    public void shouldBeOneBookMoreFromAvailableBooksIfIsReturned(){
//        int numberBookExpected = 3;
//        Biblioteca biblioteca = new Biblioteca();
//
//        biblioteca.returnBook("You");
//        int numberBooksActual = biblioteca.getListResourceAvailable().size();
//        assertEquals(numberBookExpected, numberBooksActual);
//    }

    @Test
    public void shouldReturnSuccessMessageIfReturned(){
        String successMessageExpected = "Thank you for returning the book";
        Boolean isReturned = true;

        String successMessageActual = new Biblioteca().returnMessageReturn(isReturned);

        assertEquals( successMessageExpected, successMessageActual);
    }

    @Test
    public void shouldReturnMessageIfBookAlreadyInLibrary(){
        String successMessageExpected = "That is not a valid book to return";
        Boolean isReturned = false;

        String successMessageActual = new Biblioteca().returnMessageReturn(isReturned);

        assertEquals( successMessageExpected, successMessageActual);
    }

    /* Check type of Resource */
    @Test
    public void shouldReturnTrueIfIsInstanceOfBook(){
        Resource book = new Book("Book1", true, "2016", "Autor");

        Boolean actual = new Biblioteca().isInstanceOfBook(book);

        assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfIsInstanceOfMovie(){
        Resource movie = new Movie("Movie1", true, "1678", "Director", "5");

        Boolean actual = new Biblioteca().isInstanceOfMovie(movie);

        assertTrue(actual);
    }
}
