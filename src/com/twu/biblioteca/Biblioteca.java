package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
     static String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    static String getListOfBooks(){
        List listBooks = new ArrayList<>();
        listBooks.add("Principito");
        listBooks.add("Rosas");
        listBooks.add("Mil y una noche");
        return StringUtils.join(listBooks, "\n");
    }
}
