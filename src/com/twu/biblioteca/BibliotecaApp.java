package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        String firstGreeting = Biblioteca.welcomeMessage();
        String listBooks = Biblioteca.getListOfBooks();
        System.out.println(firstGreeting);
        System.out.println(listBooks);
    }
}
