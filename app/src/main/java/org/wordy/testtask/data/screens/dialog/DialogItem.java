package org.wordy.testtask.data.screens.dialog;

public class DialogItem {

    private int id;
    private String nameAirline;
    private int price;

    public DialogItem(int id, String nameAirline, int price) {
        this.id = id;
        this.nameAirline = nameAirline;
        this.price = price;
    }

    public String getNameAirline() {
        return nameAirline;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}

