package org.wordy.testtask.data.screens.main;

import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wordy.testtask.data.data.DataBase;
import org.wordy.testtask.data.data.PortalRest;
import org.wordy.testtask.data.data.dao.CompanyDao;
import org.wordy.testtask.data.data.dao.FlightDao;
import org.wordy.testtask.data.data.dao.HotelDao;
import org.wordy.testtask.data.data.dao.HotelFlightDao;
import org.wordy.testtask.data.data.tables.Companies;
import org.wordy.testtask.data.data.tables.Flights;
import org.wordy.testtask.data.data.tables.HotelFlight;
import org.wordy.testtask.data.data.tables.Hotels;
import org.wordy.testtask.data.screens.AirlineItem;
import org.wordy.testtask.data.screens.dialog.DialogItem;

import java.io.IOException;
import java.util.ArrayList;

public class MainModel implements MainContract.Model {

    private static ArrayList<Hotels> hotels = new ArrayList<>();
    private static ArrayList<AirlineItem> airlineItems = new ArrayList<>();
    private static ArrayList<DialogItem> dialogItems = new ArrayList<>();
    private PortalRest mPortal;
    private HotelDao mHotelDao;
    private CompanyDao mCompanyDao;
    private FlightDao mFlightDao;
    private HotelFlightDao mHotelFlightDao;

    public MainModel(Application application) {
        DataBase dataBase = DataBase.getDatabase(application);
        mPortal = PortalRest.getPortal();
        this.mCompanyDao = dataBase.companyDao();
        this.mFlightDao = dataBase.flightDao();
        this.mHotelDao = dataBase.hotelDao();
        this.mHotelFlightDao = dataBase.hotelFlightDao();
    }

    public ArrayList<AirlineItem> getAirlineItems() {
        return airlineItems;
    }

    public ArrayList<DialogItem> getDialogItems() {
        return dialogItems;
    }

    @Override
    public boolean downloadHotels() {
        try {
            JSONObject jsonHotels = new JSONObject(mPortal.get("12q3ws").body().string());
            JSONArray jsonArrayOfHotels = jsonHotels.getJSONArray("hotels");
            for (int i = 0; i < jsonArrayOfHotels.length(); i++) {
                JSONObject json = jsonArrayOfHotels.getJSONObject(i);
                mHotelDao.insert(Hotels.fromJson(json));
                hotels.add(Hotels.fromJson(json));
                for (int j = 0; j < json.getJSONArray("flights").length(); j++) {
                    mHotelFlightDao.insert(new HotelFlight(json.getInt("id"), json.getJSONArray("flights").getInt(j)));
                }
            }
            return true;
        } catch (JSONException | IOException e) {
            return false;
        }
    }

    @Override
    public boolean downloadFlighs() {
        try {
            JSONObject jsonFlighs = new JSONObject(mPortal.get("zqxvw").body().string());
            JSONArray jsonArrayOfFlights = jsonFlighs.getJSONArray("flights");
            for (int i = 0; i < jsonArrayOfFlights.length(); i++) {
                JSONObject json = jsonArrayOfFlights.getJSONObject(i);
                mFlightDao.insert(Flights.fromJson(json));
            }
            return true;
        } catch (JSONException | IOException e) {
            return false;
        }
    }

    @Override
    public boolean downloadCompanies() {
        try {
            JSONObject jsonCompanies = new JSONObject(mPortal.get("8d024").body().string());
            JSONArray jsonArrayOfCompanies = jsonCompanies.getJSONArray("companies");
            for (int i = 0; i < jsonArrayOfCompanies.length(); i++) {
                JSONObject json = jsonArrayOfCompanies.getJSONObject(i);
                mCompanyDao.insert(Companies.fromJson(json));
            }
            return true;
        } catch (JSONException | IOException e) {
            return false;
        }
    }

    @Override
    public boolean setAirlineItems() {
        for (Hotels hotel : hotels) {
            airlineItems.add(new AirlineItem(
                    hotel.getId(), hotel.getName(),
                    mHotelFlightDao.getCountIds(hotel.getId()),
                    mHotelDao.getPrice(hotel.getId())
            ));
        }
        return true;
    }

    @Override
    public boolean deleteAll() {
        mHotelFlightDao.deleteAll();
        mHotelDao.deleteAll();
        mFlightDao.deleteAll();
        mCompanyDao.deleteAll();
        return true;
    }

    @Override
    public boolean setDialogItem(int id) {
        dialogItems.clear();
        for (int i : mHotelFlightDao.getIds(id)) {
            dialogItems.add(new DialogItem(id, mHotelDao.getName(id, i), mHotelDao.getAllPrice(id, i)));
        }
        return true;
    }

    @Override
    public boolean updateHotel(int position, int id) {
        mHotelDao.updatePosition(position, id);
        return true;
    }

    @Override
    public int getAirline(int id) {
        return mHotelDao.getPosition(id);
    }

}
