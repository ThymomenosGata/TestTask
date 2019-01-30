package org.wordy.testtask.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.wordy.testtask.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ProgressBar progressBar;
    private ListView airlineList;
    private AirlinesAdapter airlinesAdapter;
    private MainModel model;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        airlineList = findViewById(R.id.list_airlines);
        progressBar = findViewById(R.id.progressBar);

        model = new MainModel(getApplication());
        presenter = new MainPresenter(model, this);

        if (presenter.isOnline(this)) {
            presenter.getData();
        } else {

        }


    }

    @Override
    public void setAirlineItems(ArrayList<AirlineItem> airlineItems) {
        airlinesAdapter = new AirlinesAdapter(this, airlineItems);
        airlineList.setAdapter(airlinesAdapter);
    }

    @Override
    public void showProgressBar(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        airlineList.setVisibility(isVisible ? View.GONE : View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deleteAllDatas();
    }
}
