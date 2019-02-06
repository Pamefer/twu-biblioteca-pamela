package com.twu.biblioteca;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.ArrayList;
import java.util.List;

public abstract class BibliotecaProduct {
    private String name;
    private Boolean available;

//    public BibliotecaProduct(){
//    }

    public BibliotecaProduct(String name, Boolean available) {
        this.name = name;
        this.available = available;
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

    public void enable(){
    }

    public String toString(){
        return "";
    }
}

