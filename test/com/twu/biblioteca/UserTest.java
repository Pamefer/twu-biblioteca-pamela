package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User user;

    @Before
    public void chargeUserData(){
         user = new User( "000-0001", "1234");
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

//    @Test
//    public  void shouldReturnTrueIfSuccessLogin(){
//        String libraryNumber = "000-0001";
//        String password = "1234";
//        System.out.println(";;;;;;");
//        Boolean actual = user.login(libraryNumber, password);
//        System.out.println(actual+"kkk");
//        assertTrue(actual);
//    }


}
