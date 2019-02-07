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
        listOfTypeOfBibliotecaProduct = (userOption == LIST_BOOK_OPTION) ? listBooksAvailable: listMoviesAvailable;
        return listOfTypeOfBibliotecaProduct;
    }

    private void createListsOfProductAvailable(){
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
            if(getNameBibliotecaProduct(item).contains(resource)){
                item.setAvailable(false);
                item.setRentedBy(user);
                isResourceRemoved = true;
            }
        }
        Utililty.printOutString(returnMessageCheckout(isResourceRemoved, userOption));
        return isResourceRemoved;
    }

    public String getNameBibliotecaProduct(BibliotecaProduct bp)
    {
        if ( isInstanceOfBook(bp)) {
            Book b = (Book)bp;
            return  b.getName();
        } else if ( isInstanceOfMovie(bp) ) {
            Movie m = (Movie)bp;
            return m.getName();
        }
        return null;
    }

    Boolean returnBibliotecaProduct(String resource){
        Boolean isBookReturned = false;
        for(BibliotecaProduct item: bibliotecaProductList){
            if(getNameBibliotecaProduct(item).contains(resource) && !item.getAvailable()) {
                isBookReturned = true;
                item.setAvailable(true);
                break;
            }
        }
        Utililty.printOutString(returnMessageReturn(isBookReturned));
        return isBookReturned;
    }

    String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    void getListBibliotecaProductsRented() {
        String reservations = "";
        for (BibliotecaProduct bibliotecaProduct : bibliotecaProductList) {
            if (!bibliotecaProduct.getAvailable()) {
                if (isInstanceOfBook(bibliotecaProduct)) {
                    reservations += String.format("Book Title:%20s\nRented to:%20s\n\n", ((Book) bibliotecaProduct).getName(), bibliotecaProduct.getRentedBy().getName());
                }
                if (isInstanceOfMovie(bibliotecaProduct)) {
                    reservations += String.format("Movie Title:%20s\nRented to:%20s\n\n", ((Movie) bibliotecaProduct).getName(), bibliotecaProduct.getRentedBy().getName());
                }
            }
        }
        Utililty.printOutString(reservations);
    }

    String searchUserLogged(User user){
        return user.toString();
    }

    String returnMessageCheckout (Boolean isProductRemoved, int userOption){
        String book = "book";
        String movie = "movie";
        String selectedOption = userOption == LIST_BOOK_OPTION ? book : movie;
        return  isProductRemoved ? "Thank you, enjoy the "+ selectedOption: "Sorry, that is not available "+selectedOption;
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
