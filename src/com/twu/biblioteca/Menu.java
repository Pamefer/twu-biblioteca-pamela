package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> optionsList;
    private final int BOOK_OPTION = 1;
    private final int MOVIE_OPTION = 2;
    private final int LIST_BOOK_OPTION = 1;
    private final int LIST_MOVIE_OPTION = 2;
    private final int CHECKOUT_BOOK_OPTION = 3;
    private final int CHECKOUT_MOVIE_OPTION = 4;
    private final int RETURN_BOOK_OPTION = 5;
    private final int VIEW_RESERVATIONS_OPTION = 6;
    private final int VIEW_PROFILE_OPTION = 7;
    private final int QUIT_OPTION = 0;
    private Biblioteca biblioteca;
    private User user;


    public Menu(Biblioteca biblioteca, User user) {
        this.optionsList =  new ArrayList<>();
        this.biblioteca = biblioteca;
        this.user = user;
        optionsList.add("1. List of Books");
        optionsList.add("2. List of Movies");
        optionsList.add("3. Check out Books");
        optionsList.add("4. Check out Movies");
        optionsList.add("5. Return Books");
        optionsList.add("6. View products rented");
        optionsList.add("7. View my profile");
        optionsList.add("0. Quit");
    }


    void readInputOption(){
        String option;
        do{
            Utililty.printOutString("\n***** Select an option *****");
            String result = Utililty.concatList(optionsList);
            Utililty.printOutString(result);
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
                Utililty.printOutString(biblioteca.showBibliotecaProduct(BOOK_OPTION));
                break;
            case LIST_MOVIE_OPTION:
                Utililty.printOutString(biblioteca.showBibliotecaProduct(MOVIE_OPTION));
                break;
            case CHECKOUT_BOOK_OPTION:
                Utililty.printOutString("\nPlease enter the name of the BOOK to CHECK-OUT:");
                String bookToCheckOut = Utililty.readConsoleInput();
                Boolean isBookRemoved = biblioteca.checkoutBibliotecaProduct(bookToCheckOut, BOOK_OPTION, user);
                Utililty.printOutString(biblioteca.returnMessageCheckout(isBookRemoved));
                break;
            case CHECKOUT_MOVIE_OPTION:
                Utililty.printOutString("\nPlease enter the name of the MOVIE to CHECK-OUT:");
                String movieToCheckOut = Utililty.readConsoleInput();
                Boolean isMovieRemoved = biblioteca.checkoutBibliotecaProduct(movieToCheckOut, MOVIE_OPTION, user);
                Utililty.printOutString(biblioteca.returnMessageCheckout(isMovieRemoved));
                break;
            case RETURN_BOOK_OPTION:
                Utililty.printOutString("\nPlease enter the name of the book to RETURN:");
                String bookToReturn = Utililty.readConsoleInput();
                Boolean isBookReturn= biblioteca.returnBibliotecaProduct(bookToReturn);
                Utililty.printOutString(biblioteca.returnMessageReturn(isBookReturn));
                break;
            case VIEW_RESERVATIONS_OPTION:
                biblioteca.getListBibliotecaProductsRented();
                break;
            case VIEW_PROFILE_OPTION:
                Utililty.printOutString(biblioteca.searchUserLogged(user));
                break;
            case QUIT_OPTION:
                Utililty.printOutString("Exit");
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
