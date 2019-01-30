package org.wordy.testtask.screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.wordy.testtask.R;

import java.util.ArrayList;

public class AirlinesAdapter extends BaseAdapter {

    private Context ctx;
    private LayoutInflater inflater;
    private ArrayList<AirlineItem> objects;

    public AirlinesAdapter(Context ctx, LayoutInflater inflater, ArrayList<AirlineItem> objects) {
        this.ctx = ctx;
        this.objects = objects;
        this.inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.result_item, parent, false);
        }

        AirlineItem item = getAirlineItem(position);

        TextView name = view.findViewById(R.id.hostel_name);
        TextView count = view.findViewById(R.id.count_airlines);
        TextView price = view.findViewById(R.id.price);

        name.setText(item.getName());
        if (item.getCount() > 1) {
            price.setText("от " + item.getPirce() + " р");
        } else {
            price.setText(item.getPirce() + " р");
        }

        if (item.getCount() > 4 && item.getCount() < 21) {
            count.setText(item.getCount() + " вариантов перелета");
        } else if (item.getCount() > 1 && item.getCount() < 5) {
            count.setText(item.getCount() + " варианта перелета");
        } else {
            count.setText(item.getCount() + " вариант перелета");
        }


        return view;
    }

    AirlineItem getAirlineItem(int position) {
        return ((AirlineItem) getItem(position));
    }
}
