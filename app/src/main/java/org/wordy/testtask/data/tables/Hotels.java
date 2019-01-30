package org.wordy.testtask.data.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@Entity(tableName = "hotel")
public class Hotels {

    @PrimaryKey
    private int id;
    private String name;
    private int price;

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

    public static Hotels fromJson(JSONObject jsonObject) throws JSONException {
        Hotels hotels = new Hotels();
        hotels.id = jsonObject.getInt("id");
        hotels.name = jsonObject.getString("name");
        hotels.price = jsonObject.getInt("price");
        return hotels;
    }

}
