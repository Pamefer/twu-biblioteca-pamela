package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ResourceObjects {
    private List<Resource> resourcesList;
    private List<Resource> listBooksAvailable;
    private List<Resource> listMoviesAvailable;

    private UserObjects userObjects;
    private ReservationObjects reservationObjects;
    private List<Reservation> reservationList;

    public ResourceObjects(){}

    public ResourceObjects(List<Resource> resourcesList,UserObjects userObjects) {

        this.resourcesList = resourcesList;
        this.userObjects = userObjects;
        this.reservationList = new ArrayList<>();
        this.reservationObjects = new ReservationObjects(this.reservationList);
    }

    public List<Resource> getResourcesList() {
        return resourcesList;
    }

    List<Resource> getListResourceAvailable(int userOption) {
        List<Resource> listOfTypeOfResource = null;
        createListsOfResourcesAvailable();
        listOfTypeOfResource = (userOption == 1) ? listBooksAvailable : listMoviesAvailable;
        return listOfTypeOfResource;
    }

    void createListsOfResourcesAvailable(){
        listBooksAvailable = new ArrayList<>();
        listMoviesAvailable = new ArrayList<>();
        for (Resource resource: resourcesList){
            if(resource.getAvailable() && isInstanceOfBook(resource)) {
                listBooksAvailable.add(resource);
            }
            if(resource.getAvailable() && isInstanceOfMovie(resource)){
                listMoviesAvailable.add(resource);
            }
        }
    }

    String showResources(int userOption){
        String result = "";
        for (Resource resource: getListResourceAvailable(userOption)){
            result += resource;
        }
        return result;
    }

    Boolean checkoutResource(String resource, int userOption){
        Boolean isResourceRemoved = false;
        for(Resource item: getListResourceAvailable(userOption)){
            if(item.getName().contains(resource)){
                item.setAvailable(false);
                isResourceRemoved = true;
                reservationList.add(new Reservation(userObjects.activeUser(), item));
                reservationObjects.getReservationList();
            }
        }
        return isResourceRemoved;
    }

    Boolean returnBook(String book){
        Boolean isBookReturned = false;
        for(Resource item: resourcesList){
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

    Boolean isInstanceOfBook(Resource resource){
        return resource instanceof Book;
    }

    Boolean isInstanceOfMovie(Resource resource){
        return resource instanceof Movie;
    }

}
