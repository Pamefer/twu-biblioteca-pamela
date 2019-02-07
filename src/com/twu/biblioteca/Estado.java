package com.twu.biblioteca;

public enum Estado {

    LIST_BOOK_OPTION(1),
    LIST_MOVIE_OPTION(2),
    CHECKOUT_BOOK_OPTION(3),
    CHECKOUT_MOVIE_OPTION(4),
    RETURN_BOOK_OPTION(5),
    VIEW_RESERVATIONS_OPTION(6),
    VIEW_PROFILE_OPTION(7),
    QUIT_OPTION(0);
    private int option;


    private Estado(int option) {
        this.option= option;
    }

    private int getOption() {
        return option;
    }

    public static Estado fetchValue(int constant) {
        for (Estado week : Estado.values()) {
            if (week.getOption() == constant) {
                return week;
            }
        }
        return null;
    }
}
