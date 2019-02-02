package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> optionsList;
    private final int LIST_BOOK_OPTION = 1;
    private final int LIST_MOVIE_OPTION = 2;
    private final int CHECKOUT_RESOURCE_OPTION = 3;
    private final int RETURN_RESOURCE_OPTION = 4;
    private final int QUIT_OPTION = 5;
    private Biblioteca biblioteca;
    ;

    public Menu(Biblioteca biblioteca) {
        this.optionsList =  new ArrayList<>();
        this.biblioteca = biblioteca;
        optionsList.add("1. List of Books");
        optionsList.add("2. List of Movies");
        optionsList.add("3. Check out Books");
        optionsList.add("4. Return Books");
        optionsList.add("5. Quit");
    }


    void readInputOption(){
        System.out.println("\n***** Select an option *****");
        String option;
        do{
            String result = Utililty.concatList(optionsList);
            System.out.println(result);
            do{
                option = Utililty.readConsoleInput();
            }while(!Utililty.isValidOption(option, optionsList));
            selectOption(option);
        }while (isOptionToQuit(Integer.parseInt(option)));
    }

     void selectOption(String option){
        int options = Integer.parseInt(option);
        switch (options){
            case LIST_BOOK_OPTION:
                System.out.println(biblioteca.listarRecursos(LIST_BOOK_OPTION));
                break;
            case LIST_MOVIE_OPTION:
                System.out.println(biblioteca.listarRecursos(LIST_MOVIE_OPTION));
                break;
            case CHECKOUT_RESOURCE_OPTION:
                System.out.println("\nPlease enter the name of the book to CHECK-OUT:");
                String bookToCheckOut = Utililty.readConsoleInput();
                Boolean isBookRemoved = biblioteca.checkoutBook(bookToCheckOut);
//                    resource = new Resource();
//                    Boolean isBookRemoved2 = resource.checkout(bookToCheckOut, getListResourceAvailable());
                System.out.println(biblioteca.returnMessageCheckout(isBookRemoved));
                break;
            case RETURN_RESOURCE_OPTION:
                System.out.println("\nPlease enter the name of the book to RETURN:");
                String bookToReturn = Utililty.readConsoleInput();
                Boolean isBookReturn= biblioteca.returnBook(bookToReturn);
                System.out.println(biblioteca.returnMessageReturn(isBookReturn));
                break;
            case QUIT_OPTION:
                System.out.println("Exit");
                System.exit(0);
                break;
        }
    }

    Boolean isOptionToQuit (int option){
        return option != QUIT_OPTION;
    }

    public List<String> getOptionsList() {
        return optionsList;
    }
}
