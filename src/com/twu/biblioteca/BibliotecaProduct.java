package com.twu.biblioteca;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.ArrayList;
import java.util.List;

public interface BibliotecaProduct {

    User getRentedBy();
    Boolean getAvailable();
    void setAvailable(Boolean available);
    void setRentedBy(User rentedBy);

    String toString();
}

