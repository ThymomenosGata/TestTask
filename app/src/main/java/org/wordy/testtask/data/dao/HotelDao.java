package org.wordy.testtask.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.wordy.testtask.data.tables.Hotels;

@Dao
public interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Hotels hotels);

    @Update
    void update(Hotels hotels);

    @Query("DELETE FROM hotel")
    void deleteAll();

    @Query("select min(hotel.price) + min(flight.price) from hotel inner join flight where hotel.id = :id")
    int getPrice(int id);

}
