package org.wordy.testtask.data.screens.main;

import android.content.Context;

import org.wordy.testtask.data.screens.AirlineItem;
import org.wordy.testtask.data.screens.dialog.DialogItem;

import java.util.ArrayList;
import java.util.List;

public interface MainContract {

    interface View {
        void setAirlineItems(ArrayList<AirlineItem> airlineItems);

        void showProgressBar(boolean isVisible);

        void showMainDialog(List<DialogItem> dialogItems, int position);
    }

    interface Presenter {
        boolean isOnline(Context context);

        void getData();

        void deleteAllDatas();

        void getItems(int id);

        void updatePosition(int position, int hotelId);

    }

    interface Model {
        boolean downloadHotels();

        boolean downloadFlighs();

        boolean downloadCompanies();

        boolean setAirlineItems();

        boolean deleteAll();

        boolean setDialogItem(int id);

        boolean updateHotel(int position, int id);

        int getAirline(int id);
    }

}
