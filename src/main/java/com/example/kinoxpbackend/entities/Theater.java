package com.example.kinoxpbackend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Theater {

    @Id
    private String name;
    private int rows;
    private int seatsPrRow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsPrRow() {
        return seatsPrRow;
    }

    public void setSeatsPrRow(int seatsPrRow) {
        this.seatsPrRow = seatsPrRow;
    }
}
