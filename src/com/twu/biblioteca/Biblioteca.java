package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<BibliotecaProduct> bibliotecaProductList;
    private List<User> usersList;

    private List<BibliotecaProduct> listBooksAvailable;
    private List<BibliotecaProduct> listMoviesAvailable;

    private final int LIST_BOOK_OPTION = 1;
    private final int DEFAULT_OPTION = 1;

    Biblioteca(List<BibliotecaProduct> resourcesList, List<User> usersList ){
        this.bibliotecaProductList = resourcesList;
        this.usersList = usersList;
    }

    public List<BibliotecaProduct> getListResourceAvailable(int userOption) {
        List<BibliotecaProduct> listOfTypeOfBibliotecaProduct = null;
        createListsOfResourcesAvailable();
        listOfTypeOfBibliotecaProduct = (userOption == LIST_BOOK_OPTION) ? listBooksAvailable : listMoviesAvailable;
        return listOfTypeOfBibliotecaProduct;
    }

    void createListsOfResourcesAvailable(){
        listBooksAvailable = new ArrayList<>();
        listMoviesAvailable = new ArrayList<>();
        for (BibliotecaProduct bibliotecaProduct : bibliotecaProductList){
            if(bibliotecaProduct.getAvailable() && isInstanceOfBook(bibliotecaProduct)) {
                listBooksAvailable.add(bibliotecaProduct);
            }
            if(bibliotecaProduct.getAvailable() && isInstanceOfMovie(bibliotecaProduct)){
                listMoviesAvailable.add(bibliotecaProduct);
            }
        }
    }

    String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    String showResources(int userOption){
        String result = "";
        for (BibliotecaProduct bibliotecaProduct : getListResourceAvailable(userOption)){
            result += bibliotecaProduct;
        }
        return result;
    }


    Boolean checkoutResource(String resource, int userOption){
        Boolean isResourceRemoved = false;
        for(BibliotecaProduct item: getListResourceAvailable(userOption)){
            if(item.getName().contains(resource)){
                item.setAvailable(false);
                isResourceRemoved = true;
            }
        }
        return isResourceRemoved;
    }

    Boolean returnBook(String book){
        Boolean isBookReturned = false;
        for(BibliotecaProduct item: bibliotecaProductList){
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

    Boolean isInstanceOfBook(BibliotecaProduct bibliotecaProduct){
        return bibliotecaProduct instanceof Book;
    }

    Boolean isInstanceOfMovie(BibliotecaProduct bibliotecaProduct){
        return bibliotecaProduct instanceof Movie;
    }
}
