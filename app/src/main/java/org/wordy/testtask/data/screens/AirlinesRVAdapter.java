package org.wordy.testtask.data.screens;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.wordy.testtask.R;

import java.util.List;

public class AirlinesRVAdapter extends RecyclerView.Adapter<AirlinesRVAdapter.AirlinesHolder> {

    private List<AirlineItem> airlineItems;

    public class AirlinesHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView name, count, price;

        public AirlinesHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_airline);
            name = itemView.findViewById(R.id.hostel_name);
            count = itemView.findViewById(R.id.count_airlines);
            price = itemView.findViewById(R.id.price);
        }
    }

    public AirlinesRVAdapter(List<AirlineItem> airlineItems) {
        this.airlineItems = airlineItems;
    }

    @NonNull
    @Override
    public AirlinesRVAdapter.AirlinesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.result_item, viewGroup, false);
        return new AirlinesHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AirlinesRVAdapter.AirlinesHolder airlinesHolder, int i) {
        airlinesHolder.name.setText("Отель \"" + airlineItems.get(i).getName() + "\"");
        airlinesHolder.card.setTag(airlineItems.get(i).getHomeId());
        if (airlineItems.get(i).getCount() > 1) {
            airlinesHolder.price.setText("от " + Integer.toString(airlineItems.get(i).getPirce()) + " р");
        } else {
            airlinesHolder.price.setText(Integer.toString(airlineItems.get(i).getPirce()) + " р");
        }
        if (airlineItems.get(i).getCount() > 4 && airlineItems.get(i).getCount() < 21) {
            airlinesHolder.count.setText(Integer.toString(airlineItems.get(i).getCount()) + " вариантов перелета");
        } else if (airlineItems.get(i).getCount() > 1 && airlineItems.get(i).getCount() < 5) {
            airlinesHolder.count.setText(Integer.toString(airlineItems.get(i).getCount()) + " варианта перелета");
        } else {
            airlinesHolder.count.setText(Integer.toString(airlineItems.get(i).getCount()) + " вариант перелета");
        }
    }

    @Override
    public int getItemCount() {
        return airlineItems.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
