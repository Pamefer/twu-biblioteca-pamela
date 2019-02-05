package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReservationTest {
    Reservation reservation;
    User user;
    Book book;

    @Before
    public void chargeReservationData(){
        user = new User( "000-0001", "1234", false, "Jony", "jon@gmail.com", "0989906930");
        book = new Book("Flowers", true, "1678", "Radnedy Cajas");
        reservation = new Reservation(user, book);
    }

    @Test
    public void shouldReturnUserObject(){
        assertTrue(reservation.getUser() instanceof User);
    }

//    @Test
//    public void shouldReturnBookObject(){
//        assertTrue(reservation.getBook() instanceof Book);
//    }
}
