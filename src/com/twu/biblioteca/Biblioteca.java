package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Resource> resourcesList;
    private List<Resource> listBooksAvailable;
    private List<Resource> listMoviesAvailable;
    private final int LIST_BOOK_OPTION = 1;

    Biblioteca(){
        this.resourcesList = new ArrayList<>();
        this.resourcesList.add(new Book("The Japanese girl", true, "1971", "Winston Graham"));
        this.resourcesList.add(new Book("You",true, "2015", "Pamela"));
        this.resourcesList.add(new Book("Take me out",true, "1987", "Gianella"));
        this.resourcesList.add(new Movie("Movie1", true, "1971", "Winston Graham", "3"));
        this.resourcesList.add(new Movie("Movie3",true, "2015", "Pamela","4"));
        this.resourcesList.add(new Movie("Movie3",true, "1987", "Gianella","5"));
        getListResourceAvailable(1);
    }

    public List<Resource> getListResourceAvailable(int userOption) {
        List<Resource> listOfTypeOfResource = null;
        createListsOfResourcesAvailable();
        listOfTypeOfResource = (userOption == LIST_BOOK_OPTION) ? listBooksAvailable : listMoviesAvailable;
        return listOfTypeOfResource;
    }

    void createListsOfResourcesAvailable(){
        listBooksAvailable = new ArrayList<>();
        listMoviesAvailable = new ArrayList<>();
        for (Resource resource: resourcesList){
            if(resource.getAvailable() && isInstanceOfBook(resource)) {
                listBooksAvailable.add(resource);
            }
            if(resource.getAvailable() && isInstanceOfMovie(resource)){
                listMoviesAvailable.add(resource);
            }
        }
    }

    String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    String listarRecursos(int userOption){
        String result = "";
        for (Resource resource: getListResourceAvailable(userOption)){
            result += resource;
        }
        return result;
    }

    Boolean checkoutBook(String book){
        Boolean isBookRemoved = false;
        for(Resource item: listBooksAvailable){
            if(item.getName().contains(book)){
                item.setAvailable(false);
                isBookRemoved = true;
            }
        }
        return isBookRemoved;
    }

    Boolean returnBook(String book){
        Boolean isBookReturned = false;
        for(Resource item: resourcesList){
            if(item.getName().contains(book) && !item.getAvailable()) {
                isBookReturned = true;
                item.setAvailable(true);
                break;
            }
        }
        return isBookReturned;
    }

    String returnMessageCheckout (Boolean isBookRemoved){
        return isBookRemoved ? "Thank you, enjoy the book": "Sorry, that book is not available";
    }

    String returnMessageReturn (Boolean isBookRemoved){
        return isBookRemoved ? "Thank you for returning the book": "That is not a valid book to return";
    }

    Boolean isInstanceOfBook(Resource resource){
        return resource instanceof Book;
    }

    Boolean isInstanceOfMovie(Resource resource){
        return resource instanceof Movie;
    }
}
