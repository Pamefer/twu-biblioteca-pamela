package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ResourceTest {
    private Resource resource;
    private ResourceObjects resourceObjects;
    private UserObjects userObject;
    private Biblioteca biblioteca;

    private final int BOOK_OPTION = 1;
    private final int MOVIE_OPTION = 2;


    @Before
    public void chargeResourcesOfTest(){
        biblioteca = new Biblioteca();
        resource = new Resource("Flowers", true, "2015");
        userObject = new UserObjects();
        userObject.login("1","1234");
        resourceObjects = new ResourceObjects(biblioteca.getResourcesList(), userObject);
    }

    @Test
    public void shouldGetNameOfResource() {
        String actual = resource.getName();
        assertEquals("Flowers", actual);
    }

    @Test
    public void shouldGetAvailabilityOfResource() {
        Boolean actual = resource.getAvailable();
        assertEquals(true, actual);
    }

    @Test
    public void shouldGetYearOfResource() {
        String actual = resource.getYear();
        assertEquals("2015", actual);
    }

    /* Check type of Resource */

    @Test
    public void shouldReturnTrueIfIsInstanceOfBook(){
        Resource book = new Book("Book1", true, "2016", "Autor");
        Boolean actual = resourceObjects.isInstanceOfBook(book);
        assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfIsInstanceOfMovie(){
        Resource movie = new Movie("Movie1", true, "1678", "Director", "5");
        Boolean actual = resourceObjects.isInstanceOfMovie(movie);
        assertTrue(actual);
    }

    /* Checkout Book */
    @Test
    public void shouldChekoutABook(){
        boolean isCheckoutActual = resourceObjects.checkoutResource("You", BOOK_OPTION);
        assertTrue(isCheckoutActual);
    }

    @Test
    public void shouldNotChekoutABook(){
        boolean isCheckoutActual = resourceObjects.checkoutResource("gdahjda" , BOOK_OPTION);
        assertFalse(isCheckoutActual);
    }

    @Test
    public void shouldBeOneBookLessFromAllBooksIfCheckOut(){
        int numberBookExpected = 2;
        resourceObjects.checkoutResource("You", BOOK_OPTION);
        int numberBooksActual = resourceObjects.getListResourceAvailable(1).size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

    @Test
    public void shouldNotBeOneBookLessFromAvailableBooksIfBookNotExist(){
        int numberBookExpected = 3;
        resourceObjects.checkoutResource("Me", BOOK_OPTION);
        int numberBooksActual = resourceObjects.getListResourceAvailable(1).size();
        assertEquals(numberBookExpected, numberBooksActual);
    }

    @Test
    public void shouldReturnSuccessMessageIfCheckOutTrue(){
        String successMessageExpected = "Thank you, enjoy the book";
        Boolean isCheckOut = true;
        String successMessageActual = biblioteca.returnMessageCheckout(isCheckOut);
        assertEquals( successMessageExpected, successMessageActual);
    }

    @Test
    public void shouldReturnUnSuccessMessageIfBookIsNotAvailable(){
        String unsuccessMessageExpected = "Sorry, that book is not available";
        Boolean isCheckOut = false;
        String unsuccessMessageActual = biblioteca.returnMessageCheckout(isCheckOut);
        assertEquals( unsuccessMessageExpected, unsuccessMessageActual);
    }

    /* Return Book */

    @Test
    public void shouldNotReturnABook(){
        boolean isReturnActual = resourceObjects.returnBook("Adasdasd");
        assertFalse(isReturnActual);
    }

    @Test
    public void shouldBeOneBookMoreFromAvailableBooksIfIsReturned(){
        int numberBookExpected = 3;
        resourceObjects.returnBook("You");
        int numberBooksActual = resourceObjects.getListResourceAvailable(1).size();
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
        boolean isCheckoutActual = resourceObjects.checkoutResource("MovieX", MOVIE_OPTION);
        assertFalse(isCheckoutActual);
    }

    @Test
    public void shouldBeOneMovieLessFromAllMoviesIfCheckOut(){
        int numberMoviesExpected = 2;
        resourceObjects.checkoutResource("Movie1", MOVIE_OPTION);
        int numberMoviesActual = resourceObjects.getListResourceAvailable(MOVIE_OPTION).size();
        assertEquals(numberMoviesExpected, numberMoviesActual);
    }


    @Test
    public void shouldNotBeOneMovieLessFromAvailableMoviesIfMovieNotExist(){
        int numberMoviesExpected = 3;
        resourceObjects.checkoutResource("MovieX", MOVIE_OPTION);
        int numberMoviesActual = resourceObjects.getListResourceAvailable(MOVIE_OPTION).size();
        assertEquals(numberMoviesExpected, numberMoviesActual);
    }


}
