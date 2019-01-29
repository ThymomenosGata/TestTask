package org.wordy.testtask.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import org.wordy.testtask.data.dao.CompanyDao;
import org.wordy.testtask.data.dao.FlightDao;
import org.wordy.testtask.data.dao.HotelDao;
import org.wordy.testtask.data.tables.Companies;
import org.wordy.testtask.data.tables.Flights;
import org.wordy.testtask.data.tables.Hotels;

@Database(
        entities = {
                Hotels.class,
                Companies.class,
                Flights.class
        }, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {

    private static DataBase INSTANCE;

    public abstract FlightDao flightDao();

    public abstract HotelDao hotelDao();

    public abstract CompanyDao companyDao();


    public static DataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataBase.class, "org.wordy.test_task.database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
