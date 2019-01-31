package org.wordy.testtask.data.screens.main;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.wordy.testtask.R;
import org.wordy.testtask.data.data.OnCompleteListener;
import org.wordy.testtask.data.data.Result;
import org.wordy.testtask.data.screens.AirlineItem;
import org.wordy.testtask.data.screens.AirlinesRVAdapter;
import org.wordy.testtask.data.screens.dialog.DialogItem;
import org.wordy.testtask.data.screens.dialog.MainDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ProgressBar progressBar;
    private RecyclerView airlineList;
    private MainPresenter presenter;
    private MainDialog mainDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        airlineList = findViewById(R.id.list_airlines);
        progressBar = findViewById(R.id.progressBar);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        airlineList.setLayoutManager(llm);

        MainModel model = new MainModel(getApplication());
        presenter = new MainPresenter(model, this);

        if (presenter.isOnline(this)) {
            presenter.getData();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.error)
                    .setMessage(R.string.error_connection)
                    .setIcon(R.drawable.ic_error_outline_black_24dp)
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override
    public void setAirlineItems(ArrayList<AirlineItem> airlineItems) {
        AirlinesRVAdapter airlinesAdapter = new AirlinesRVAdapter(airlineItems);
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

    public void cardClicked(View view) {
        int homeId = (Integer) view.getTag();
        presenter.getItems(homeId);
    }

    @Override
    public void showMainDialog(final List<DialogItem> dialogItems, int position) {

        Collections.sort(dialogItems, new Comparator<DialogItem>() {
            @Override
            public int compare(DialogItem o1, DialogItem o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        });

        mainDialog = MainDialog.newInstance(dialogItems, position, new OnCompleteListener() {
            @Override
            public void onComplete(Result result) {
                Toast.makeText(getApplicationContext(), "this is " + result.getObject(), Toast.LENGTH_LONG).show();
                presenter.updatePosition((Integer) result.getObject(), dialogItems.get(0).getId());
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (dialogItems.size() != 0) {
            mainDialog.show(fragmentManager, "dialog");
        }
    }


}
