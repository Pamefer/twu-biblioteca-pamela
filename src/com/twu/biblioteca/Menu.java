package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> optionsList;

    private final int BOOK_OPTION = 1;
    private final int MOVIE_OPTION = 2;
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
        int optionCast = Integer.parseInt(option);
        Status selection = Status.fetchValue(optionCast);
        selection.execute(biblioteca, user);
    }

    Boolean isOptionToQuit (int option){
        return option != 0;
    }

    public List<String> getOptionsList() {
        return optionsList;
    }
}
