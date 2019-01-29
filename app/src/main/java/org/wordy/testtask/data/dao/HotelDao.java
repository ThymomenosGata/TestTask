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
    void update(Hotels checkin);

    @Query("DELETE FROM hotel")
    void deleteAll();

}
