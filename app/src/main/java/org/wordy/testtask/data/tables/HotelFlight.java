package org.wordy.testtask.data.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

@Entity(
        tableName = "hotel_flight",
        primaryKeys = {"hotelId", "flightId"},
        foreignKeys = @ForeignKey(
                entity = Flights.class,
                parentColumns = "id",
                childColumns = "flightId",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        ), indices = @Index("flightId")
)
public class HotelFlight {

    private int hotelId;
    private int flightId;

    public HotelFlight(int hotelId, int flightId) {
        this.hotelId = hotelId;
        this.flightId = flightId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

}
