package org.wordy.testtask.data.screens.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

public class DialogLVAdapter extends ArrayAdapter<DialogItem> {

    public DialogLVAdapter(@NonNull Context context, @NonNull List<DialogItem> objects) {
        super(context, 0, objects);

    }

}
