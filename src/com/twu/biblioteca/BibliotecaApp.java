package com.twu.biblioteca;

import java.sql.SQLOutput;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        String firstGreeting = biblioteca.welcomeMessage();

        System.out.println(firstGreeting);
        biblioteca.readInputOption();


    }


}
