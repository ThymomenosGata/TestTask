package org.wordy.testtask.data.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(
        tableName = "flight",
        foreignKeys = @ForeignKey(
                entity = Companies.class,
                parentColumns = "id",
                childColumns = "companyId",
                onDelete = CASCADE,
                onUpdate = CASCADE
        ), indices = @Index("companyId")
)
public class Flights {

    @PrimaryKey
    private int id;
    private int companyId;
    private int price;

    public Flights() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Flights fromJson(JSONObject jsonObject) throws JSONException {
        Flights flights = new Flights();
        flights.id = jsonObject.getInt("id");
        flights.companyId = jsonObject.getInt("companyId");
        flights.price = jsonObject.getInt("price");
        return flights;
    }

}
