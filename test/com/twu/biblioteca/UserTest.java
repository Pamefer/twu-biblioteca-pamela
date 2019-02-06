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
    }

//    @Test
//    public  void shouldReturnTrueIfSuccessLogin(){
//        String libraryNumber = "1";
//        String password = "1234";
//        User actual = userSet.login(libraryNumber, password);
//        assertTrue(actual);
//    }
//
//    @Test
//    public  void shouldReturnFalseIfIncorrectLogin(){
//        String libraryNumber = "000-0007";
//        String password = "1234";
//        Boolean actual = userObjects.login(libraryNumber, password);
//        assertFalse(actual);
//    }
}
