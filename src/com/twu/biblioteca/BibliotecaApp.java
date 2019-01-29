package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        int number = 0;
        String firstGreeting = Biblioteca.welcomeMessage();
        System.out.println(firstGreeting);
        System.out.println("***** Select an options *****");
        System.out.println(Biblioteca.showOptions());
        Biblioteca.readInputOption();
//        System.out.println(Biblioteca.getListOfBooks());
    }
}
