package com.twu.biblioteca;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        UserObjects user = new UserObjects();
        System.out.printf("^^^^^Login^^^^^");
        System.out.println("Enter library number");
        String libraryNumberInput = Utililty.readConsoleInput();
        System.out.println("Enter password");
        String passwordInput = Utililty.readConsoleInput();
        Boolean successLogin = user.login(libraryNumberInput,passwordInput);
        if(successLogin){
            Biblioteca biblioteca = new Biblioteca();
            String firstGreeting = biblioteca.welcomeMessage();
            System.out.println(firstGreeting);

            Menu menu = new Menu(biblioteca);
            menu.readInputOption();
        }else{
            System.out.println("Incorrect login");
        }

    }

    private static List<Resource> addResources(){
         List<Resource>  resourcesList=  new ArrayList<>();
        resourcesList.add(new Book("The Japanese girl", true, "1971", "Winston Graham"));
        resourcesList.add(new Book("You",true, "2015", "Pamela"));
        resourcesList.add(new Book("Take me out",true, "1987", "Gianella"));
        resourcesList.add(new Movie("Movie1", true, "1971", "Winston Graham", "3"));
        resourcesList.add(new Movie("Movie3",true, "2015", "Pamela","4"));
        resourcesList.add(new Movie("Movie3",true, "1987", "Gianella","5"));
        return resourcesList;
    }
}
