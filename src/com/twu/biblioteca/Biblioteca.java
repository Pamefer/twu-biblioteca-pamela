package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

     static String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    static String showOptions(){
         List<String> optionsList = new ArrayList<>();
         optionsList.add("1. List of Books");
         String result = concatList(optionsList);
         return result;
    }

    static void readInputOption(){
        Scanner scan = new Scanner(System.in);
        int option;
        try{
            do{
                option = scan.nextInt();
            }while(!isValidOption(option));
        } catch (InputMismatchException e){
            System.out.println("Please, select a valid option!");
        }
    }

    static boolean isValidOption(int option){
        boolean isValid = true;
        if(option != 1){
            isValid = false;
            System.out.println("Please, select a valid option!");
        }
         return isValid;
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

    private static String concatList(List<String> newList){
        String result = "";
        for (String b: newList){
            result += b + "\n";
        }
        return result;
    }
}
