package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Resource> resourcesList;

    private UserObjects userObjects;
    private ReservationObjects reservationObjects;
    private List<Reservation> reservationList;

    Biblioteca(){
        this.resourcesList = new ArrayList<>();
        this.userObjects = userObjects;
        this.reservationList = new ArrayList<>();
        this.reservationObjects = new ReservationObjects(this.reservationList);
        this.resourcesList.add(new Book("The Japanese girl", true, "1971", "Winston Graham"));
        this.resourcesList.add(new Book("You",true, "2015", "Pamela"));
        this.resourcesList.add(new Book("Take me out",true, "1987", "Gianella"));
        this.resourcesList.add(new Movie("Movie1", true, "1971", "Winston Graham", "3"));
        this.resourcesList.add(new Movie("Movie3",true, "2015", "Pamela","4"));
        this.resourcesList.add(new Movie("Movie3",true, "1987", "Gianella","5"));
    }

    public List<Resource> getResourcesList() {
        return resourcesList;
    }

    String welcomeMessage(){
        String greeting = "\nWelcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
        return greeting;
    }

    String returnMessageCheckout (Boolean isBookRemoved){
        return isBookRemoved ? "Thank you, enjoy the book": "Sorry, that book is not available";
    }

    String returnMessageReturn (Boolean isBookRemoved){
        return isBookRemoved ? "Thank you for returning the book": "That is not a valid book to return";
    }
}
