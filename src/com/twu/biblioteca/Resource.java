package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Resource {
    private String name;
    private Boolean available;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Resource(){

    }

    public Resource(String name, Boolean available) {
        this.name = name;
        this.available = available;
        this.book = new Book();
    }

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

//    public Book getBook() {
//        return book;
//    }

    public Boolean checkout(String book, List<Resource> listBooksAvailable){
        Boolean isBookRemoved = false;
        for(Resource resource: listBooksAvailable){
            if(resource.getName().contains(book)){
                resource.setAvailable(false);
                isBookRemoved = true;
            }
        }
        return isBookRemoved;
    }

}

