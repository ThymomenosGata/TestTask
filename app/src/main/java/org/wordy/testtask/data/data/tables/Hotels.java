package org.wordy.testtask.data.data.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "hotel")
public class Hotels {

    @PrimaryKey
    private int id;
    private String name;
    private int price;
    private int position;

    public Hotels() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public static Hotels fromJson(JSONObject jsonObject) throws JSONException {
        Hotels hotels = new Hotels();
        hotels.id = jsonObject.getInt("id");
        hotels.name = jsonObject.getString("name");
        hotels.price = jsonObject.getInt("price");
        hotels.position = 0;
        return hotels;
    }

}
