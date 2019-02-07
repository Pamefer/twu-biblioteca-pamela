package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<BibliotecaProduct> bibliotecaProductList;
    private List<Book> listBooksAvailable;
    private List<Movie> listMoviesAvailable;
    private final int LIST_BOOK_OPTION = 1;

    Biblioteca(List<BibliotecaProduct> bibliotecaProductList){
        this.bibliotecaProductList = bibliotecaProductList;
    }


    String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }


    void fillListOfTypesBibliotecaProduct() {
        listBooksAvailable = new ArrayList<>();
        listMoviesAvailable = new ArrayList<>();
        for (BibliotecaProduct bibliotecaProduct : bibliotecaProductList) {
            if (bibliotecaProduct.getAvailable() && isInstanceOfBook(bibliotecaProduct)) {
                listBooksAvailable.add((Book) bibliotecaProduct);
            }
            if (bibliotecaProduct.getAvailable() && isInstanceOfMovie(bibliotecaProduct)) {
                listMoviesAvailable.add((Movie) bibliotecaProduct);
            }
        }
    }

    List<Book> getTotalListBook(){
        List<Book> bookList = new ArrayList<>();
        for(BibliotecaProduct bibliotecaProduct: bibliotecaProductList){
            if(isInstanceOfBook(bibliotecaProduct)){
                bookList.add((Book) bibliotecaProduct);
            }
        }
        return bookList;
    }

    List<Movie> getListMoviesAvailable(){
        fillListOfTypesBibliotecaProduct();
        return listMoviesAvailable;
    }

    List<Book> getListBooksAvailable(){
        fillListOfTypesBibliotecaProduct();
        return listBooksAvailable;
    }

    String showBibliotecaBook(){
        fillListOfTypesBibliotecaProduct();
        String result = "";
            for (BibliotecaProduct b : listBooksAvailable){
                result += b;
        }
        return result;
    }

    String showBibliotecaMovie(){
        fillListOfTypesBibliotecaProduct();
        String result = "";
        for (BibliotecaProduct b : listMoviesAvailable){
            result += b;
        }
        return result;
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

    Boolean checkoutBook (String resource, int userOption, User user){
        Boolean isResourceRemoved = false;
        for(Book item: getListBooksAvailable()){
            if(item.getName().contains(resource)){
                item.setAvailable(false);
                item.setRentedBy(user);
                isResourceRemoved = true;
            }
        }
        Utililty.printOutString(returnMessageCheckout(isResourceRemoved, userOption));
        return isResourceRemoved;
    }

    Boolean checkoutMovie (String resource, int userOption, User user){
        Boolean isResourceRemoved = false;
        for(Movie item: getListMoviesAvailable()){
            if(item.getName().contains(resource)){
                item.setAvailable(false);
                item.setRentedBy(user);
                isResourceRemoved = true;
            }
        }
        Utililty.printOutString(returnMessageCheckout(isResourceRemoved, userOption));
        return isResourceRemoved;
    }


    Boolean returnBook(String book){
        Boolean isBookReturned = false;
        for(Book item: getTotalListBook()){
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
