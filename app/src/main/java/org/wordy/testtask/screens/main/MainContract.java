package org.wordy.testtask.screens.main;

import android.content.Context;

import java.util.ArrayList;

public interface MainContract {

    interface View {
        void setAirlineItems(ArrayList<AirlineItem> airlineItems);

        void showProgressBar(boolean isVisible);
    }

    interface Presenter {
        boolean isOnline(Context context);

        void getData();

        void deleteAllDatas();

    }

    interface Model {
        boolean downloadHotels();

        boolean downloadFlighs();

        boolean downloadCompanies();

        boolean setAirlineItems();

        boolean deleteAll();
    }

}
