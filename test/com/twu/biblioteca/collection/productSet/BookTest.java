package com.twu.biblioteca.collection.productSet;
import com.twu.biblioteca.collection.productSet.Book;
import com.twu.biblioteca.collection.userSet.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {
    private Book book;

    @Before
    public void chargeBookOfTest(){
        User user = new User();
        book = new Book("Flowers", true, user, "1678", "Radnedy Cajas");
    }

    @Test
    public void shouldGetNameOfBook() {
        String actual = book.getName();
        assertEquals("Flowers", actual);
    }

    @Test
    public void shouldGetAvailabilityOfBook(){
        Boolean actual = book.getAvailable();
        assertTrue(actual);
    }

    @Test
    public void shouldGetYearOfBook(){
        String name = "Flowers";
        String author = "Radnedy Cajas";
        String year = "1678";
        String bookCast = book.toString();
        assertTrue(bookCast.contains(name) && bookCast.contains(author) && bookCast.contains(year));
    }

}
