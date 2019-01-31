package org.wordy.testtask.data.screens.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

public class MainPresenter implements MainContract.Presenter {

    private MainModel mModel;
    private MainContract.View mView;

    public MainPresenter(MainModel mModel, MainContract.View mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    @Override
    @SuppressLint("StaticFieldLeak")
    public void getData() {
        mView.showProgressBar(true);
        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                return mModel.downloadCompanies() && mModel.downloadFlighs() && mModel.downloadHotels() && mModel.setAirlineItems();
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if (aBoolean) {
                    mView.showProgressBar(false);
                    mView.setAirlineItems(mModel.getAirlineItems());
                } else {

                }
            }
        }.execute();
    }

    @Override
    @SuppressLint("StaticFieldLeak")
    public void getItems(final int id) {
        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... voids) {
                mModel.setDialogItem(id);
                return mModel.getAirline(id);
            }

            @Override
            protected void onPostExecute(Integer mInteger) {
                super.onPostExecute(mInteger);
                mView.showMainDialog(mModel.getDialogItems(), mInteger);

            }
        }.execute();
    }

    @Override
    @SuppressLint("StaticFieldLeak")
    public void updatePosition(final int position, final int hotelId) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                mModel.updateHotel(position, hotelId);
                return null;
            }
        }.execute();
    }

    @Override
    @SuppressLint("StaticFieldLeak")
    public void deleteAllDatas() {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                return mModel.deleteAll();
            }
        }.execute();
    }

}
