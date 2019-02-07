package com.twu.biblioteca.collection;

import com.twu.biblioteca.Utililty;
import com.twu.biblioteca.collection.userSet.User;

public enum Status {


    LIST_BOOK_OPTION(1) {
        protected void execute(Biblioteca biblioteca, User user) {
            Utililty.printOutString(biblioteca.showBibliotecaProduct(1));
        }
    },
    LIST_MOVIE_OPTION(2) {
        protected void execute(Biblioteca biblioteca, User user) {
            Utililty.printOutString(biblioteca.showBibliotecaProduct(2));
        }
    },
    CHECKOUT_BOOK_OPTION(3) {
        protected void execute(Biblioteca biblioteca, User user) {
            Utililty.printOutString("\nPlease enter the name of the BOOK to CHECK-OUT:");
            String bookToCheckOut = Utililty.readConsoleInput();
            biblioteca.checkoutBibliotecaProduct(bookToCheckOut, 1, user);
        }
    },
    CHECKOUT_MOVIE_OPTION(4) {
        protected void execute(Biblioteca biblioteca, User user) {
            Utililty.printOutString("\nPlease enter the name of the MOVIE to CHECK-OUT:");
            String movieToCheckOut = Utililty.readConsoleInput();
            biblioteca.checkoutBibliotecaProduct(movieToCheckOut, 2, user);
        }
    },
    RETURN_BOOK_OPTION(5) {
        protected void execute(Biblioteca biblioteca, User user) {
            Utililty.printOutString("\nPlease enter the name of the book to RETURN:");
            String bookToReturn = Utililty.readConsoleInput();
            biblioteca.returnBibliotecaProduct(bookToReturn);
        }
    },
    VIEW_RESERVATIONS_OPTION(6) {
        protected void execute(Biblioteca biblioteca, User user) {
            biblioteca.getListBibliotecaProductsRented();
        }
    },
    VIEW_PROFILE_OPTION(7) {
        protected void execute(Biblioteca biblioteca, User user) {
            Utililty.printOutString(biblioteca.searchUserLogged(user));
        }
    },
    QUIT_OPTION(0) {
        protected void execute(Biblioteca biblioteca, User user) {
                Utililty.printOutString("Exit");
                System.exit(0);
        }
    };

    private int option;


    private Status(int option) {
        this.option = option;
    }

    private int getOption() {
        return option;
    }

    protected static Status fetchValue(int constant) {
        for (Status item : Status.values()) {
            if (item.getOption() == constant) {
                return item;
            }
        }
        return null;
    }

    protected abstract void execute(Biblioteca biblioteca, User user);

}
