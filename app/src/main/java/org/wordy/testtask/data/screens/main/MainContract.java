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

        void showMainDialog(List<DialogItem> dialogItems);
    }

    interface Presenter {
        boolean isOnline(Context context);

        void getData();

        void deleteAllDatas();

        void getItems(final int id);

    }

    interface Model {
        boolean downloadHotels();

        boolean downloadFlighs();

        boolean downloadCompanies();

        boolean setAirlineItems();

        boolean deleteAll();

        boolean setDialogItem(int id);
    }

}
