package org.wordy.testtask.data.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.wordy.testtask.data.data.tables.Hotels;

@Dao
public interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Hotels hotels);

    @Update
    void update(Hotels hotels);

    @Query("DELETE FROM hotel")
    void deleteAll();

    @Query("select min(hotel.price) + min(flight.price) " +
            "from hotel_flight inner join flight inner join hotel " +
            "where hotel_flight.hotelId = hotel.id and hotel.id = :id and hotel_flight.flightId = flight.id")
    int getPrice(int id);

    @Query("select hotel.price + flight.price " +
            "from hotel_flight inner join flight inner join hotel inner join company " +
            "where hotel_flight.hotelId = hotel.id and hotel.id = :id and hotel_flight.flightId = flight.id and flight.id = :flId")
    int getAllPrice(int id, int flId);

    @Query("select company.name " +
            "from hotel inner join hotel_flight inner join flight inner join company " +
            "where hotel_flight.hotelId = hotel.id and hotel.id = :id " +
            "and hotel_flight.flightId = flight.id and flight.id = :flId and flight.companyId = company.id")
    String getName(int id, int flId);

    @Query("select position from hotel where id = :id")
    int getPosition(int id);

    @Query("update hotel set position = :position where id = :id")
    void updatePosition(int position, int id);

}
