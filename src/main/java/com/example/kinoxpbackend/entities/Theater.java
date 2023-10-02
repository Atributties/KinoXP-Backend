package com.example.kinoxpbackend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Theater {

    @Id
    private String name;
    private int numberOfRows;
    private int seatsPrRow;




    @OneToOne(mappedBy = "theater")
    private Reservation reservation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRows() {
        return numberOfRows;
    }

    public void setRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getSeatsPrRow() {
        return seatsPrRow;
    }

    public void setSeatsPrRow(int seatsPrRow) {
        this.seatsPrRow = seatsPrRow;
    }
}
