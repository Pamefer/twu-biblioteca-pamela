package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<BibliotecaProduct> bibliotecaProductList;
    private List<BibliotecaProduct> listBooksAvailable;
    private List<BibliotecaProduct> listMoviesAvailable;

    private final int LIST_BOOK_OPTION = 1;

    Biblioteca(List<BibliotecaProduct> bibliotecaProductList){
        this.bibliotecaProductList = bibliotecaProductList;
    }

    public List<BibliotecaProduct> getListBibliotecaProductAvailable(int userOption) {
        List<BibliotecaProduct> listOfTypeOfBibliotecaProduct = null;
        createListsOfProductAvailable();
        listOfTypeOfBibliotecaProduct = (userOption == LIST_BOOK_OPTION) ? listBooksAvailable : listMoviesAvailable;
        return listOfTypeOfBibliotecaProduct;
    }

    void getListBibliotecaProductsRented(){
        String reservations = "";
        for (BibliotecaProduct bibliotecaProduct : bibliotecaProductList){
            if(!bibliotecaProduct.getAvailable()){
                reservations += String.format("Title:%20s\nRented to:%20s\n\n", bibliotecaProduct.getName(), bibliotecaProduct.getRentedBy().getName());
            }
        }
        Utililty.printOutString(reservations);
    }


    void createListsOfProductAvailable(){
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

    String showBibliotecaProduct(int userOption){
        String result = "";
        for (BibliotecaProduct bibliotecaProduct : getListBibliotecaProductAvailable(userOption)){
            result += bibliotecaProduct;
        }
        return result;
    }


    Boolean checkoutBibliotecaProduct(String resource, int userOption, User user){
        Boolean isResourceRemoved = false;
        for(BibliotecaProduct item: getListBibliotecaProductAvailable(userOption)){
            if(item.getName().contains(resource)){
                item.setAvailable(false);
                item.setRentedBy(user);
                isResourceRemoved = true;
            }
        }
        Utililty.printOutString(returnMessageCheckout(isResourceRemoved, userOption));
        return isResourceRemoved;
    }

    Boolean returnBibliotecaProduct(String book){
        Boolean isBookReturned = false;
        for(BibliotecaProduct item: bibliotecaProductList){
            if(item.getName().contains(book) && !item.getAvailable()) {
                isBookReturned = true;
                item.setAvailable(true);
                break;
            }
        }
        Utililty.printOutString(returnMessageReturn(isBookReturned));
        return isBookReturned;
    }

    String searchUserLogged(User user){
        return user.toString();
    }

    String returnMessageCheckout (Boolean isBookRemoved, int userOption){
        String book = "book";
        String movie = "movie";
        String selectedOption = userOption == LIST_BOOK_OPTION ? book : movie;
        return  isBookRemoved ? "Thank you, enjoy the "+ selectedOption: "Sorry, that is not available "+movie;
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
