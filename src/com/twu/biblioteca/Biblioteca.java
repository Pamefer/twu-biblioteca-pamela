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
        this.listBooks.add(new Book("The Japanese girl", true, "Winston Graham", "1971"));
        this.listBooks.add(new Book("You",true, "Pamela","2015"));
        this.listBooks.add(new Book("Take me out",true, "Gianella","1987"));
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
            String result = concatList(optionsList);
            System.out.println(result);
            do{
                option = Utililty.readConsoleInput();
            }while(!Utililty.isValidOption(option, optionsList));
            selectOption(option);
        }while (option != "4");
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
                break;
            case 4:
                System.out.println("Exit");
                System.exit(0);
                break;
        }
    }

    String returnMessageCheckout (Boolean isBookRemoved){
        return isBookRemoved ? "Thank you, enjoy the book": "Sorry, that book is not available";
    }

    String returnMessageReturn (Boolean isBookRemoved){
        return isBookRemoved ? "Thank you for returning the book": "That is not a valid book to return";
    }

     String getBooks(){
        String result = "";
        for (Resource b: getListBooksAvailable()){
            result += String.format("%20s|\n",b.getName());
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
        for(Resource item: listBooks){ // add funtionality
            if(item.getName().contains(book)){
                item.setAvailable(true);
                isBookReturned = true;
            }
        }
        return isBookReturned;
    }

    private String concatList(List<String> newList){
        String result = "";
        for (String b: newList){
            result += b + "\n";
        }
        return result;
    }
}
