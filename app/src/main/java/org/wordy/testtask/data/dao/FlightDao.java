package org.wordy.testtask.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.wordy.testtask.data.tables.Flights;

@Dao
public interface FlightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Flights flights);

    @Update
    void update(Flights flights);

    @Query("DELETE FROM flight")
    void deleteAll();

}
