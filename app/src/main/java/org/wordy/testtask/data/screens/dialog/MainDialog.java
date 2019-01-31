package org.wordy.testtask.data.screens.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.wordy.testtask.R;
import org.wordy.testtask.data.data.OnCompleteListener;
import org.wordy.testtask.data.data.Result;

import java.util.List;

@SuppressLint("ValidFragment")
public class MainDialog extends DialogFragment {

    //private OnCompleteListener mCallback;

    private ListView mListView;
    private DialogLVAdapter mAdapter;
    private List<DialogItem> dialogItems;
    private int position;
    private OnCompleteListener mCallback;

    public static MainDialog newInstance(List<DialogItem> dialogItems, int position, OnCompleteListener mCallback) {
        Bundle args = new Bundle();
        MainDialog fragment = new MainDialog(dialogItems, position, mCallback);
        fragment.setArguments(args);
        return fragment;
    }

    public MainDialog(List<DialogItem> dialogItems, int position, OnCompleteListener mCallback) {
        this.dialogItems = dialogItems;
        this.position = position;
        this.mCallback = mCallback;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_main, null);

        mAdapter = new DialogLVAdapter(getContext(), dialogItems, position);

        mListView = view.findViewById(R.id.list_main_dialog);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }
        });

        builder.setCancelable(false);
        builder.setView(view);
        builder.setPositiveButton(getResources().getString(R.string.apply), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mCallback.onComplete(new Result<>(mAdapter.getPosition(), true));
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }
}
