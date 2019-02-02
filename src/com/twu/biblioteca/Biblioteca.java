package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Resource> resources;
    private List<Resource> listBooksAvailable;
    private List<Resource> listMoviesAvailable;
    private List<String> optionsList;
    private Resource resource;
    private final int LIST_BOOK_OPTION = 1;
    private final int LIST_MOVIE_OPTION = 2;


    Biblioteca(){
        this.resources = new ArrayList<>();
        this.resources.add(new Book("The Japanese girl", true, "1971", "Winston Graham"));
        this.resources.add(new Book("You",true, "2015", "Pamela"));
        this.resources.add(new Book("Take me out",true, "1987", "Gianella"));
        this.resources.add(new Movie("Movie1", true, "1971", "Winston Graham", "3"));
        this.resources.add(new Movie("Movie3",true, "2015", "Pamela","4"));
        this.resources.add(new Movie("Movie3",true, "1987", "Gianella","5"));
        getListResourceAvailable(1);
    }

    public List<Resource> getListResourceAvailable(int userOption) {
        List<Resource> listOfTypeOfResource=null;

        listBooksAvailable = new ArrayList<>();
        listMoviesAvailable = new ArrayList<>();
        for (Resource resource: resources){
            if(resource.getAvailable()){
                returnListDependingTypeOfResource(resource).add(resource);
            }
        }
        if(userOption == LIST_BOOK_OPTION){
            listOfTypeOfResource = listBooksAvailable;
        }
        if(userOption == LIST_MOVIE_OPTION){
            listOfTypeOfResource = listMoviesAvailable;
        }
        return listOfTypeOfResource;
    }

    List<Resource> returnListDependingTypeOfResource(Resource b){
        if(isInstanceOfBook(b)){
            return listBooksAvailable;
        }
        if(isInstanceOfMovie(b)){
            return listMoviesAvailable;
        }
        return null;
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
        for(Resource item: resources){
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
