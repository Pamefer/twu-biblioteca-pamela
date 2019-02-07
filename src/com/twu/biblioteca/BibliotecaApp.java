package com.twu.biblioteca;

import com.twu.biblioteca.collection.*;
import com.twu.biblioteca.collection.productSet.BibliotecaProduct;
import com.twu.biblioteca.collection.productSet.Book;
import com.twu.biblioteca.collection.productSet.Movie;
import com.twu.biblioteca.collection.userSet.User;
import com.twu.biblioteca.collection.userSet.UsersSet;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        UsersSet usersSet = new UsersSet();
        usersSet.chargeUsers(chargeUsers());
        Biblioteca biblioteca = new Biblioteca(chargeBibliotecaProducts());

        Utililty.printOutString(" ------------ Login ------------ \n");
        Utililty.printOutString("Enter library number:");
        String libraryNumberInput = Utililty.readConsoleInput();
        Utililty.printOutString("\nEnter password:");
        String passwordInput = Utililty.readConsoleInput();
        User userLogged = usersSet.login(libraryNumberInput, passwordInput);

        if (usersSet.isUserLogged(userLogged)) {
            String firstGreeting = biblioteca.welcomeMessage();
            Utililty.printOutString(firstGreeting);
            Menu menu = new Menu(biblioteca, userLogged);
            menu.readInputOption();
        } else {
            Utililty.printOutString("Incorrect login");
        }

    }

    public static List<BibliotecaProduct> chargeBibliotecaProducts() {
        List<BibliotecaProduct> bibliotecaProductList = new ArrayList<>();
        User user = new User();
        bibliotecaProductList.add(new Book("The Japanese girl", true, user, "1971", "Winston Graham"));
        bibliotecaProductList.add(new Book("You", true, user, "2015", "Pamela"));
        bibliotecaProductList.add(new Book("Take me out", true, user, "1987", "Gianella"));
        bibliotecaProductList.add(new Movie("Movie1", true, user, "1971", "Winston Graham", "3"));
        bibliotecaProductList.add(new Movie("Movie2", true, user, "2015", "Pamela", "4"));
        bibliotecaProductList.add(new Movie("Movie3", true, user, "1987", "Gianella", "5"));
        return bibliotecaProductList;
    }

    public static List<User> chargeUsers() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("2", "1234", false, "jose", "jose@gmail.com", "78658437563"));
        usersList.add(new User("3", "1234", false, "pancha", "pancha@gmail.com", "634353455"));
        usersList.add(new User("1", "1234", false, "Jony", "jon@gmail.com", "0989906930"));
        return usersList;
    }


}
