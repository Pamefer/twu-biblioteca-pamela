package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        String firstGreeting = biblioteca.welcomeMessage();
        System.out.println(firstGreeting);

        System.out.println("\n***** Select an option *****");
        System.out.println(biblioteca.showOptions());
        biblioteca.readInputOption();
    }


}
