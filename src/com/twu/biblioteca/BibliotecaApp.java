package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        String firstGreeting = Biblioteca.welcomeMessage();
        System.out.println(firstGreeting);
        System.out.println("***** Select an options *****");
        System.out.println(Biblioteca.showOptions());
//        System.out.println(Biblioteca.getListOfBooks());
    }
}
