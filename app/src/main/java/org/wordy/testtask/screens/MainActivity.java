package org.wordy.testtask.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.wordy.testtask.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public ProgressBar progressBar;
    public ListView airlineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showProgressBar(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        airlineList.setVisibility(isVisible ? View.GONE : View.VISIBLE);
    }

}
