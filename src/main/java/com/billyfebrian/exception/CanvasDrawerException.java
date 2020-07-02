package com.billyfebrian.exception;

public class CanvasDrawerException extends Exception {

    private String message;

    public CanvasDrawerException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
