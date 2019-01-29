package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

     static String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    static String getListOfBooks(){
         String result = "";
        List <Book> listBooks = new ArrayList<>();
        listBooks.add(new Book("The Japanese girl"));
        listBooks.add(new Book("Your life"));
        listBooks.add(new Book("Take me out"));

        result = concatListOfBooks(listBooks);

        return result;
    }

    private static String concatListOfBooks(List<Book> booksList){
        String result = "";
        for (Book b: booksList){
            result += b.getName() + "\n";
        }
         return result;
    }
}
