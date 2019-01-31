package org.wordy.testtask.data.data;

public class Result<T> {

    private T object;
    private boolean isSuccessful;
    private String message;

    public Result(T object, boolean isSuccessful, String message) {
        this.object = object;
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    public Result(T object, boolean isSuccessful) {
        this.object = object;
        this.isSuccessful = isSuccessful;
    }

    public Result(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    public Result(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public T getObject() {
        return object;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public String getMessage() {
        return message;
    }


}
