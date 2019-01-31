package org.wordy.testtask.data.screens.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import org.wordy.testtask.R;

import java.util.List;

public class DialogLVAdapter extends ArrayAdapter<DialogItem> {

    private RadioButton checkedButton;
    private TextView price;
    private int positionChecked;
    private List<DialogItem> objects;

    public DialogLVAdapter(@NonNull Context context, @NonNull List<DialogItem> objects, int positionChecked) {
        super(context, 0, objects);
        this.positionChecked = positionChecked;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_dialog, parent, false);
        }

        DialogItem currentDialogItem = objects.get(position);

        checkedButton = listItemView.findViewById(R.id.radioButton);
        price = listItemView.findViewById(R.id.price);
        checkedButton.setChecked(positionChecked == position);
        checkedButton.setText(currentDialogItem.getNameAirline());
        price.setText(Integer.toString(currentDialogItem.getPrice()));

        checkedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionChecked = position;
                checkedButton.setChecked(true);
                notifyDataSetChanged();
            }
        });

        return listItemView;
    }

    public int getPosition() {
        return positionChecked;
    }
}
