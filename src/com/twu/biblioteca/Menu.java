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
    private final int QUIT_OPTION = 0;
    private Biblioteca biblioteca;
    private ResourceObjects resourceObjects;
    private ReservationObjects reservationObjects;


    public Menu(Biblioteca biblioteca, UserObjects userObjects) {
        this.optionsList =  new ArrayList<>();
        this.biblioteca = biblioteca;
        this.resourceObjects = new ResourceObjects(biblioteca.getResourcesList(),userObjects);
        optionsList.add("1. List of Books");
        optionsList.add("2. List of Movies");
        optionsList.add("3. Check out Books");
        optionsList.add("4. Check out Movies");
        optionsList.add("5. Return Books");
        optionsList.add("5. View reservations");
        optionsList.add("0. Quit");
    }


    public void readInputOption(){
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

     private void selectOption(String option){
        int options = Integer.parseInt(option);

        switch (options){
            case LIST_BOOK_OPTION:
                System.out.println(resourceObjects.showResources(BOOK_OPTION));
                break;
            case LIST_MOVIE_OPTION:
                System.out.println(resourceObjects.showResources(MOVIE_OPTION));
                break;
            case CHECKOUT_BOOK_OPTION:
                System.out.println("\nPlease enter the name of the BOOK to CHECK-OUT:");
                String bookToCheckOut = Utililty.readConsoleInput();
                Boolean isBookRemoved = resourceObjects.checkoutResource(bookToCheckOut, BOOK_OPTION);
                System.out.println(biblioteca.returnMessageCheckout(isBookRemoved));
                break;
            case CHECKOUT_MOVIE_OPTION:
                System.out.println("\nPlease enter the name of the MOVIE to CHECK-OUT:");
                String movieToCheckOut = Utililty.readConsoleInput();
                Boolean isMovieRemoved = resourceObjects.checkoutResource(movieToCheckOut, MOVIE_OPTION);
                System.out.println(biblioteca.returnMessageCheckout(isMovieRemoved));
                break;
            case RETURN_BOOK_OPTION:
                System.out.println("\nPlease enter the name of the book to RETURN:");
                String bookToReturn = Utililty.readConsoleInput();
                Boolean isBookReturn= resourceObjects.returnBook(bookToReturn);
                System.out.println(biblioteca.returnMessageReturn(isBookReturn));
                break;
            case VIEW_RESERVATIONS_OPTION:
                reservationObjects.getReservationList();

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
