package com.twu.biblioteca;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.ArrayList;
import java.util.List;

public abstract class BibliotecaProduct {
    private String name;
    private Boolean available;
    private User rentedBy;

    public BibliotecaProduct(String name, Boolean available, User rentedBy) {
        this.name = name;
        this.available = available;
        this.rentedBy = rentedBy;
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

    public User getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(User rentedBy) {
        this.rentedBy = rentedBy;
    }

    public abstract String toString();
}

