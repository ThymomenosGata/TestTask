package org.wordy.testtask.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.wordy.testtask.data.tables.HotelFlight;

@Dao
public interface HotelFlightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HotelFlight hotelFlight);

    @Update
    void update(HotelFlight hotelFlight);

    @Query("DELETE FROM hotel_flight")
    void deleteAll();

    @Query("select COUNT(flightId) from hotel_flight where hotelId = :id")
    int getCountIds(int id);

    @Query("select flightId from hotel_flight where hotelId = :id")
    int[] getIds(int id);

}
