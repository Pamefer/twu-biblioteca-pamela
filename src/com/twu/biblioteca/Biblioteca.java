package com.twu.biblioteca;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Book> listBooks;
    private List<Book> listBooksAvailable;
    private List<String> optionsList;

    Scanner scan = new Scanner(System.in);


    Biblioteca(){
        this.listBooks = new ArrayList<>();
        this.listBooks.add(new Book("The Japanese girl", "Winston Graham", "1971", true));
        this.listBooks.add(new Book("You","Pamela","2015", true));
        this.listBooks.add(new Book("Take me out","Gianella","1987", true));
        showOptions();
        getListBooksAvailable();
    }


    public List<Book> getListBooksAvailable() {
        listBooksAvailable = new ArrayList<>();
        for (Book b: listBooks){
            if(b.getAvailable()){
                listBooksAvailable.add(b);
            }
        }
        return listBooksAvailable;
    }

    public List<String> getOptionsList() {
        return optionsList;
    }

    String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    String showOptions(){
        optionsList = new ArrayList<>();
        optionsList.add("1. List of Books");
         optionsList.add("2. Quit");
         String result = concatList(optionsList);
         return result;
    }

    void readInputOption(){
        String option;
        do{
            option = readConsoleInput();
        }while(!isValidOption(option, optionsList));
        selectOption(option);
    }

    void selectOption(String option){
        int options = Integer.parseInt(option);
        switch (options){
            case 1:
                System.out.println(getBooks());
                System.out.println("\n Select an option\n1. Check-out\n2. Return book");
                String optionBook = readConsoleInput();
                System.out.println(optionBook);
                if(optionBook.equals("1")){
                    System.out.println("\nPlease enter the name of the book to CHECK-OUT:");
                    String bookToCheckOut = readConsoleInput();
                    Boolean isBookRemoved = checkoutBook(bookToCheckOut);
                    System.out.println(returnMessage(isBookRemoved));
                }
                if(optionBook.equals("2")){
                    System.out.println("\nPlease enter the name of the book to RETURN:");
                    String bookToReturn = readConsoleInput();
                    Boolean isBookReturn= returnBook(bookToReturn);
                }
        }
    }

    String returnMessage (Boolean isBookRemoved){
        return isBookRemoved ? "Thank you, enjoy the book": "Sorry, that book is not available";
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

    Boolean checkoutBook(String book){
        Boolean isBookRemoved = false;
        for(Book item: listBooksAvailable){
            if(item.getName().contains(book)){
                item.setAvailable(false);
                isBookRemoved = true;
            }
        }
        listBooksAvailable.forEach(item -> System.out.println(item.getAuthor()+item.getAvailable()));
        return isBookRemoved;
    }

    Boolean returnBook(String book){
        Boolean isBookReturned = false;
        for(Book item: listBooks){
            if(item.getName().contains(book)){
                item.setAvailable(true);
                isBookReturned = true;
            }
        }
        listBooksAvailable.forEach(item -> System.out.println(item.getAuthor()+item.getAvailable()));
        return isBookReturned;
    }

    private String concatList(List<String> newList){
        String result = "";
        for (String b: newList){
            result += b + "\n";
        }
        return result;
    }

    boolean isValidOption(String option, List<String> optionsList){
        boolean isValid = true;
        try{
            int options = Integer.parseInt(option);
            if(options == 0 || options > optionsList.size() ){
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
