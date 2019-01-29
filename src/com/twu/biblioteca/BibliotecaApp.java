package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        String firstGreeting = Biblioteca.welcomeMessage();
        System.out.println(firstGreeting);
        System.out.println("\n***** Select an option *****");
        System.out.println(Biblioteca.showOptions());
        Biblioteca.readInputOption();
    }
}
