package org.wordy.testtask.data.screens.dialog;

public class DialogItem {

    private String nameAirline;
    private int price;

    public DialogItem(String nameAirline, int price) {
        this.nameAirline = nameAirline;
        this.price = price;
    }

    public String getNameAirline() {
        return nameAirline;
    }

    public int getPrice() {
        return price;
    }
}

