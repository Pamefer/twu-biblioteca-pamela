package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    User user;

    @Before
    public void chargeUserData(){
         user = new User( "000-0001", "pass123");
    }

    @Test
    public void shouldReturnLibraryNumber(){
        String expected = "000-0001";
        String actual = user.getLibraryNumber();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPassword(){
        String expected = "pass123";
        String actual = user.getPassword();
        assertEquals(expected, actual);
    }
}
