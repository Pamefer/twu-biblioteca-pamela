package com.twu.biblioteca.collection.productSet;

import com.twu.biblioteca.collection.userSet.User;

public interface BibliotecaProduct {

    User getRentedBy();
    Boolean getAvailable();
    void setAvailable(Boolean available);
    void setRentedBy(User rentedBy);

    String toString();
}

