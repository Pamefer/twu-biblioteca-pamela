package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void chargeBookOfTest(){
        User user = new User();
        book = new Book("Flowers", true, user, "1678", "Radnedy Cajas");
    }

//    @Test
//    public void shouldGetNameOfBook() {
//        String actual = book.getName();
//        assertEquals("Flowers", actual);
//    }
}
