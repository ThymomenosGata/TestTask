package org.wordy.testtask.screens;

public class AirlineItem {

    private String name;
    private int count;
    private int pirce;

    public AirlineItem(String name, int count, int pirce) {
        this.name = name;
        this.count = count;
        this.pirce = pirce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPirce() {
        return pirce;
    }

    public void setPirce(int pirce) {
        this.pirce = pirce;
    }
}
