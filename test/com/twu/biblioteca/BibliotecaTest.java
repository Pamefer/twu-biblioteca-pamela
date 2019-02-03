package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaTest {
    List<Book> listBooks = new ArrayList<>();
    private final int BOOK_OPTION = 1;
    private final int MOVIE_OPTION = 2;

    @Test
    public void shouldReturnWelcomeMessage() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
        String actual = new Biblioteca().welcomeMessage();
        assertEquals(expected, actual);
    }

    /* Check out book */
    @Test
    public void shouldChekoutABook(){
        Biblioteca biblioteca = new Biblioteca();

        boolean isCheckoutActual = biblioteca.checkoutResource("You", BOOK_OPTION);

        assertTrue(isCheckoutActual);
    }

    @Test
    public void shouldNotChekoutABook(){
        Biblioteca biblioteca = new Biblioteca();

        boolean isCheckoutActual = biblioteca.checkoutResource("dgadah" , BOOK_OPTION);

        assertFalse(isCheckoutActual);
    }

    @Test
    public void shouldBeOneBookLessFromAllBooksIfCheckOut(){
        int numberBookExpected = 2;
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.checkoutResource("You", BOOK_OPTION);
        int numberBooksActual = biblioteca.getListResourceAvailable(1).size();
        assertEquals(numberBookExpected, numberBooksActual);
    }


    @Test
    public void shouldNotBeOneBookLessFromAvailableBooksIfBookNotExist(){
        int numberBookExpected = 3;
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.checkoutResource("Me", BOOK_OPTION);
        int numberBooksActual = biblioteca.getListResourceAvailable(1).size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

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

    /* ask ??*/
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

    @Test
    public void shouldBeOneBookMoreFromAvailableBooksIfIsReturned(){
        int numberBookExpected = 3;
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.returnBook("You");
        int numberBooksActual = biblioteca.getListResourceAvailable(1).size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

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

    /* Checkout Movie */

    @Test
    public void shouldNotChekoutAMovie(){
        Biblioteca biblioteca = new Biblioteca();

        boolean isCheckoutActual = biblioteca.checkoutResource("MovieX",MOVIE_OPTION);

        assertFalse(isCheckoutActual);
    }

//    @Test
//    public void shouldBeOneBookLessFromAllBooksIfCheckOut(){
//        int numberBookExpected = 2;
//        Biblioteca biblioteca = new Biblioteca();
//
//        biblioteca.checkoutBook("You");
//        int numberBooksActual = biblioteca.getListResourceAvailable(1).size();
//        assertEquals(numberBookExpected, numberBooksActual);
//    }
//
//
//    @Test
//    public void shouldNotBeOneBookLessFromAvailableBooksIfBookNotExist(){
//        int numberBookExpected = 3;
//        Biblioteca biblioteca = new Biblioteca();
//
//        biblioteca.checkoutBook("Me");
//        int numberBooksActual = biblioteca.getListResourceAvailable(1).size();
//        assertEquals(numberBookExpected, numberBooksActual);
//    }
//
//    @Test
//    public void shouldReturnSuccessMessageIfCheckOutTrue(){
//        String successMessageExpected = "Thank you, enjoy the book";
//        Boolean isCheckOut = true;
//
//        String successMessageActual = new Biblioteca().returnMessageCheckout(isCheckOut);
//
//        assertEquals( successMessageExpected, successMessageActual);
//    }
//
//    @Test
//    public void shouldReturnUnSuccessMessageIfBookIsNotAvailable(){
//        String unsuccessMessageExpected = "Sorry, that book is not available";
//        Boolean isCheckOut = false;
//
//        String unsuccessMessageActual = new Biblioteca().returnMessageCheckout(isCheckOut);
//
//        assertEquals( unsuccessMessageExpected, unsuccessMessageActual);
//    }
}
