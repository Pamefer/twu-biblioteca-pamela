package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void chhargeBookOfTest(){
        book = new Book("Flowers", true, "Radnedy Cajas", "1678");
    }

    @Test
    public void shouldGetNameOfBook() {
        String actual = book.getName();
        assertEquals("Flowers", actual);
    }

    @Test
    public void shouldGetAuthorOfBook(){
        String actual = book.getAuthor();
        assertEquals("Radnedy Cajas", actual);
    }

    @Test
    public void shouldGetYearOfBook(){
        String actual = book.getYear();
        assertEquals("1678", actual);
    }
}
