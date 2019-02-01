package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {


    private List<Resource> listBooks;
    private List<Resource> listBooksAvailable;
    private List<String> optionsList;
    private Resource resource;


    Biblioteca(){
        this.listBooks = new ArrayList<>();
        this.listBooks.add(new Book("The Japanese girl", true, "1971", "Winston Graham"));
        this.listBooks.add(new Book("You",true, "2015", "Pamela"));
        this.listBooks.add(new Book("Take me out",true, "1987", "Gianella"));
        showOptions();
        getListBooksAvailable();
    }

    public List<Resource> getListBooksAvailable() {
        listBooksAvailable = new ArrayList<>();
        for (Resource b: listBooks){
            if(b.getAvailable()){
                listBooksAvailable.add(b);
            }
        }
        return listBooksAvailable;
    }

    public List<String> getOptionsList() {
        return optionsList;
    }

    String welcomeMessage(){
         String greeting = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
         return greeting;
    }

    void showOptions(){
        optionsList = new ArrayList<>();
        optionsList.add("1. List of Books");
        optionsList.add("2. Check out Books");
        optionsList.add("3. Return Books");
        optionsList.add("4. Quit");
    }

    void readInputOption(){
        System.out.println("\n***** Select an option *****");
        String option = "1";
        do{
            String result = Utililty.concatList(optionsList);
            System.out.println(result);
            do{
                option = Utililty.readConsoleInput();
            }while(!Utililty.isValidOption(option, optionsList));
            selectOption(option);
        }while (isOptionToQuit(option));
    }


    void selectOption(String option){
        int options = Integer.parseInt(option);
        switch (options){
            case 1:
                System.out.println(getBooks());
                break;
            case 2:
                System.out.println("\nPlease enter the name of the book to CHECK-OUT:");
                String bookToCheckOut = Utililty.readConsoleInput();
                Boolean isBookRemoved = checkoutBook(bookToCheckOut);
//                    resource = new Resource();
//                    Boolean isBookRemoved2 = resource.checkout(bookToCheckOut, getListBooksAvailable());
                System.out.println(returnMessageCheckout(isBookRemoved));
                break;
            case 3:
                System.out.println("\nPlease enter the name of the book to RETURN:");
                String bookToReturn = Utililty.readConsoleInput();
                Boolean isBookReturn= returnBook(bookToReturn);
                System.out.println(returnMessageReturn(isBookReturn));
                break;
            case 4:
                System.out.println("Exit");
                System.exit(0);
                break;
        }
    }

     String getBooks(){
        String result = "";
        for (Resource b: getListBooksAvailable()){
            result += b;
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
        for(Resource item: listBooks){
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

    Boolean isOptionToQuit (String option){
        return option != "4";
    }
}
