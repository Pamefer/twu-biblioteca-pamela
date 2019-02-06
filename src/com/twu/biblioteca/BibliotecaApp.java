package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        UsersSet usersSet = new UsersSet();
        usersSet.chargeUsers(chargeUsers());
        Biblioteca biblioteca = new Biblioteca(chargeBibliotecaProducts());

        System.out.printf(" ------------ Login ------------ \n");
        System.out.println("Enter library number:");
        String libraryNumberInput = Utililty.readConsoleInput();
        System.out.println("\nEnter password:");
        String passwordInput = Utililty.readConsoleInput();
        Boolean successLogin = usersSet.login(libraryNumberInput,passwordInput);

        if(successLogin){
            String firstGreeting = biblioteca.welcomeMessage();
            System.out.println(firstGreeting);
            Menu menu = new Menu(biblioteca);
            menu.readInputOption();
        }else{
            System.out.println("Incorrect login");
        }
    }

    public static List<BibliotecaProduct> chargeBibliotecaProducts(){
        List<BibliotecaProduct> bibliotecaProductList= new ArrayList<>();
        bibliotecaProductList.add(new Book("The Japanese girl", true, "1971", "Winston Graham"));
        bibliotecaProductList.add(new Book("You",true, "2015", "Pamela"));
        bibliotecaProductList.add(new Book("Take me out",true, "1987", "Gianella"));
        bibliotecaProductList.add(new Movie("Movie1", true, "1971", "Winston Graham", "3"));
        bibliotecaProductList.add(new Movie("Movie3",true, "2015", "Pamela","4"));
        bibliotecaProductList.add(new Movie("Movie3",true, "1987", "Gianella","5"));
        return bibliotecaProductList;
    }

    public static List<User> chargeUsers(){
        List<User> usersList= new ArrayList<>();
        usersList.add( new User("2", "1234", false,"jose", "jose@gmail.com", "78658437563"));
        usersList.add( new User("3", "1234", false, "pancha", "pancha@gmail.com", "634353455"));
        usersList.add( new User("1", "1234", false, "Jony", "jon@gmail.com", "0989906930"));
        return usersList;
    }


}
