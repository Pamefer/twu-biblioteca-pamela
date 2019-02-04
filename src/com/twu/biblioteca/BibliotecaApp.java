package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        /* Get Login data of user */
        UserObjects user = new UserObjects();
        System.out.printf("^^^^^Login^^^^^\n");
        System.out.println("Enter library number:\n");
        String libraryNumberInput = Utililty.readConsoleInput();
        System.out.println("Enter password:\n");
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

}
