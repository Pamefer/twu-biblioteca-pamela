package com.twu.biblioteca.collection.productSet;
import com.twu.biblioteca.collection.productSet.Book;
import com.twu.biblioteca.collection.userSet.User;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void chargeBookOfTest(){
        User user = new User();
        book = new Book("Flowers", true, user, "1678", "Radnedy Cajas");
    }
}
