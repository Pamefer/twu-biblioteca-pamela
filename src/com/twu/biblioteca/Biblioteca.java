package com.twu.biblioteca;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Book> listBooks;
    Scanner scan = new Scanner(System.in);


    Biblioteca(){
        this.listBooks = new ArrayList<>();
        this.listBooks.add(new Book("The Japanese girl", "Winston Graham", "1971"));
        this.listBooks.add(new Book("You","Pamela","2015"));
        this.listBooks.add(new Book("Take me out","Gianella","1987"));
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    String showOptions(){
         List<String> optionsList = new ArrayList<>();
         optionsList.add("1. List of Books");
         String result = concatList(optionsList);
         return result;
    }

    void readInputOption(){
        String option;
        do{
            option = readConsoleInput();
        }while(!isValidOption(option));
        selectOption(option);
    }

    void selectOption(String option){
        int options = Integer.parseInt(option);
        switch (options){
            case 1:
                System.out.println(getBooks());
                System.out.println("\nPlease enter the name of the book to check-out:");
                String bookToCheckOut = readConsoleInput();
                removeBook(bookToCheckOut);
        }
    }

     String getBooks(){
        String result = "";
        for (Book b: listBooks){
            result += String.format("|%20s|%20s|%20s|\n",b.getName(), b.getAuthor(), b.getYear());
        }
        return result;
    }

     String readConsoleInput(){
        String input = scan.nextLine();
        return input;
    }

    void removeBook(String book){
        for(Book item: listBooks){
            if(item.getName().contains(book)){
                listBooks.remove(item);
            }
        }
        listBooks.forEach(item -> System.out.println(item.getAuthor()));
    }

    private String concatList(List<String> newList){
        String result = "";
        for (String b: newList){
            result += b + "\n";
        }
        return result;
    }

    boolean isValidOption(String option){
        boolean isValid = true;
        try{
            int options = Integer.parseInt(option);
            if(options != 1){
                isValid = false;
                System.out.println("Please, select a valid option!");
            }
        }catch(NumberFormatException e){
            System.out.println("Please, select a number");
            isValid = false;
        }
        return isValid;
    }


}
