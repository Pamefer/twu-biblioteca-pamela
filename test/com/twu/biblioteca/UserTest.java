package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user;
    UserObjects userObjects;

    @Before
    public void chargeUserData(){
         user = new User( "000-0001", "1234", false, "Jony", "jony@gmail.com", "0989906930");
         userObjects = new UserObjects();
    }

    @Test
    public void shouldReturnLibraryNumber(){
        String expected = "000-0001";
        String actual = user.getLibraryNumber();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPassword(){
        String expected = "1234";
        String actual = user.getPassword();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnStatusSession(){
        Boolean expected = false;
        Boolean actual = user.getStatusSession();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnName(){
        String expected = "Jony";
        String actual = user.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMail(){
        String expected = "jony@gmail.com";
        String actual = user.getMail();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPhone(){
        String expected = "0989906930";
        String actual = user.getPhone);
        assertEquals(expected, actual);
    }

    @Test
    public  void shouldReturnTrueIfSuccessLogin(){
        String libraryNumber = "1";
        String password = "1234";
        Boolean actual = userObjects.login(libraryNumber, password);
        assertTrue(actual);
    }

    @Test
    public  void shouldReturnFalseIfIncorrectLogin(){
        String libraryNumber = "000-0007";
        String password = "1234";
        Boolean actual = userObjects.login(libraryNumber, password);
        assertFalse(actual);
    }




}
