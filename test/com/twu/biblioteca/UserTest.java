package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    User user;
    UsersSet userSet;

    @Before
    public void chargeUserData(){
        user = new User( "000-0001", "1234", false, "Jony", "jony@gmail.com", "0989906930");
        userSet = new UsersSet();
        userSet.chargeUsers(BibliotecaApp.chargeUsers());
    }

    @Test
    public void shoukdRetornSringInfoUser(){
        String stringExpected = "";
        String stringActual = user.toString();
        assertEquals(stringExpected,stringActual);
    }

    @Test
    public  void shouldReturnUserIfSuccessLogin(){
        String libraryNumber = "1";
        String password = "1234";
        User actual = userSet.login(libraryNumber, password);
        assertTrue(actual instanceof User);
    }

    @Test
    public  void shouldReturnFalseIfIncorrectLogin(){
        String libraryNumber = "000-0007";
        String password = "1234";
        User actual = userSet.login(libraryNumber, password);
        assertTrue(actual == null);
    }
}
