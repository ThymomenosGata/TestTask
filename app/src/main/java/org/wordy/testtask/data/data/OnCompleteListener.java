package org.wordy.testtask.data.data;

public interface OnCompleteListener<T> {
    void onComplete(Result<T> result);
}