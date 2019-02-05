package com.twu.biblioteca;

import java.util.List;

public class ReservationObjects {
    private List<Reservation> reservationList;

    public ReservationObjects(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public void getReservationList() {
        for (Reservation reservation: reservationList ){
            System.out.println(reservation);
        }
    }

}
