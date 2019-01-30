package org.wordy.testtask.data.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "company")
public class Companies {
    @PrimaryKey
    private int id;
    private String name;

    public Companies() {
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

    public static Companies fromJson(JSONObject jsonObject) throws JSONException {
        Companies companies = new Companies();
        companies.id = jsonObject.getInt("id");
        companies.name = jsonObject.getString("name");
        return companies;
    }

}
