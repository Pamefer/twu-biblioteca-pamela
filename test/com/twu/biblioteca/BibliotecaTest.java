package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private User user = new User();
    private final int BOOK_OPTION = 1;
    private final int MOVIE_OPTION = 2;

    @Before
    public void chargeData(){
        biblioteca = new Biblioteca(BibliotecaApp.chargeBibliotecaProducts());
    }

    @Test
    public void shouldReturnWelcomeMessage() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
        String actual = biblioteca.welcomeMessage();
        assertEquals(expected, actual);
    }

    /* Check type of Resource */

    @Test
    public void shouldReturnTrueIfIsInstanceOfBook(){
        BibliotecaProduct book = new Book("Book1", true, user, "2016", "Autor");
        Boolean actual = biblioteca.isInstanceOfBook(book);
        assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfIsInstanceOfMovie(){
        BibliotecaProduct movie = new Movie("Movie1", true, user, "1678", "Director", "5");
        Boolean actual = biblioteca.isInstanceOfMovie(movie);
        assertTrue(actual);
    }

    /* Checkout Book */

    @Test
    public void shouldChekoutABook(){
        boolean isCheckoutActual = biblioteca.checkoutBibliotecaProduct("You", BOOK_OPTION, user);
        assertTrue(isCheckoutActual);
    }

    @Test
    public void shouldNotChekoutABook(){
        boolean isCheckoutActual = biblioteca.checkoutBibliotecaProduct("gdahjda" , BOOK_OPTION, user);
        assertFalse(isCheckoutActual);
    }

    @Test
    public void shouldBeOneBookLessFromAllBooksIfCheckOut(){
        int numberBookExpected = 2;
        biblioteca.checkoutBibliotecaProduct("You", BOOK_OPTION, user);
        int numberBooksActual = biblioteca.getListBibliotecaProductAvailable(1).size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

    @Test
    public void shouldNotBeOneBookLessFromAvailableBooksIfBookNotExist(){
        int numberBookExpected = 3;
        biblioteca.checkoutBibliotecaProduct("Me", BOOK_OPTION, user);
        int numberBooksActual = biblioteca.getListBibliotecaProductAvailable(1).size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

    @Test
    public void shouldReturnSuccessMessageIfCheckOutTrue(){
        String successMessageExpected = "Thank you, enjoy the book";
        Boolean isCheckOut = true;
        String successMessageActual = biblioteca.returnMessageCheckout(isCheckOut, BOOK_OPTION);
        assertEquals( successMessageExpected, successMessageActual);
    }

    @Test
    public void shouldReturnUnSuccessMessageIfBookIsNotAvailable(){
        String unsuccessMessageExpected = "Sorry, that is not available book";
        Boolean isCheckOut = false;
        String unsuccessMessageActual = biblioteca.returnMessageCheckout(isCheckOut, BOOK_OPTION);
        assertEquals( unsuccessMessageExpected, unsuccessMessageActual);
    }

    /* Return Book */

    @Test
    public void shouldNotReturnABook(){
        boolean isReturnActual = biblioteca.returnBibliotecaProduct("Adasdasd");
        assertFalse(isReturnActual);
    }

    @Test
    public void shouldBeOneBookMoreFromAvailableBooksIfIsReturned(){
        int numberBookExpected = 3;
        biblioteca.returnBibliotecaProduct("You");
        int numberBooksActual = biblioteca.getListBibliotecaProductAvailable(1).size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

    @Test
    public void shouldReturnSuccessMessageIfReturned(){
        String successMessageExpected = "Thank you for returning the book";
        Boolean isReturned = true;
        String successMessageActual = biblioteca.returnMessageReturn(isReturned);
        assertEquals( successMessageExpected, successMessageActual);
    }

    @Test
    public void shouldReturnMessageIfBookAlreadyInLibrary(){
        String successMessageExpected = "That is not a valid book to return";
        Boolean isReturned = false;
        String successMessageActual = biblioteca.returnMessageReturn(isReturned);
        assertEquals( successMessageExpected, successMessageActual);
    }



    /* Checkout Movie */

    @Test
    public void shouldNotChekoutAMovie(){
        boolean isCheckoutActual = biblioteca.checkoutBibliotecaProduct("MovieX", MOVIE_OPTION, user);
        assertFalse(isCheckoutActual);
    }

    @Test
    public void shouldBeOneMovieLessFromAllMoviesIfCheckOut(){
        int numberMoviesExpected = 2;
        biblioteca.checkoutBibliotecaProduct("Movie1", MOVIE_OPTION, user);
        int numberMoviesActual = biblioteca.getListBibliotecaProductAvailable(MOVIE_OPTION).size();
        assertEquals(numberMoviesExpected, numberMoviesActual);
    }


    @Test
    public void shouldNotBeOneMovieLessFromAvailableMoviesIfMovieNotExist(){
        int numberMoviesExpected = 3;
        biblioteca.checkoutBibliotecaProduct("MovieX", MOVIE_OPTION, user);
        int numberMoviesActual = biblioteca.getListBibliotecaProductAvailable(MOVIE_OPTION).size();
        assertEquals(numberMoviesExpected, numberMoviesActual);
    }

    @Test
    public void shouldAddUserInBibliotecaProductWhenIsChekout(){
        biblioteca.checkoutBibliotecaProduct("You", BOOK_OPTION, user);

    }



}
