package org.wordy.testtask.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.wordy.testtask.data.tables.Companies;

@Dao
public interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Companies companies);

    @Update
    void update(Companies companies);

    @Query("DELETE FROM company")
    void deleteAll();

}
