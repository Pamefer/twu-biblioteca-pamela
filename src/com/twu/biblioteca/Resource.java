package com.twu.biblioteca;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.ArrayList;
import java.util.List;

public class Resource {
    private String name;
    private Boolean available;
    private String year;

    public Resource(){

    }

    public Resource(String name, Boolean available, String year) {
        this.name = name;
        this.available = available;
        this.year = year;
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

    public String getYear() {
        return year;
    }

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

