package org.wordy.testtask.data.screens;

public class AirlineItem {

    private int homeId;
    private String name;
    private int count;
    private int pirce;

    public AirlineItem(int homeId, String name, int count, int pirce) {
        this.homeId = homeId;
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

    public int getHomeId() {
        return homeId;
    }
}
